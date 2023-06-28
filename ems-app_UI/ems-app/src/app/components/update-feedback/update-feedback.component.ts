import { Component } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { Feedback } from 'src/app/model/feedback';
import { Rating } from 'src/app/model/rating';
import { FeedbackService } from 'src/app/services/feedback/feedback.service';
import { RatingService } from 'src/app/services/Rating/rating.service';


@Component({
  selector: 'app-update-feedback',
  templateUrl: './update-feedback.component.html',
  styleUrls: ['./update-feedback.component.css']
})
export class UpdateFeedbackComponent {
  feedback_id:any;
 feedback : Feedback = new Feedback();
 ratings: Rating[] | undefined;
  constructor(private service : FeedbackService , private route : Router, private router: ActivatedRoute,
    private serv : RatingService){}

  ngOnInit(){
    this.router.params.subscribe(params => {
      this.feedback_id = params['id'];
    });

    this.serv.getRatingList().subscribe((data) => {
      // console.log(data);
      this.ratings = data
    });
    
      this.service.getFeedbackbyId(this.feedback_id).subscribe((data:any)=>{
        this.feedback = data;
     console.log("id for feebback"+this.feedback);
    })
  }

  onsubmit() {
    // console.log(this.feedback, 23)
    this.service.updateFeedback(this.feedback_id,this.feedback).subscribe(data => {
      this.route.navigate(['feedbackList']);
      console.log(data);

    }, error=>console.error()) ;

  }
  onSelectTech(event:any) {
    this.feedback.technical_knowledge_rating = event.target.value;
  }
  onSelectWork(event:any){
    this.feedback.work_quality_rating = event.target.value;
  }

  onSelectCom(event:any){
    this.feedback.communication_rating = event.target.value;
  }
  onSelectTeam(event:any){
    this.feedback.team_playing_rating=event.target.value;
  }
  onSelectOver(event:any){
    this.feedback.overall_rating =event.target.value;
  }
}

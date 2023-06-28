import { Component } from '@angular/core';

import { Router } from '@angular/router';
import { Feedback } from 'src/app/model/feedback';
import { Rating } from 'src/app/model/rating';
import { FeedbackService } from 'src/app/services/feedback/feedback.service';


@Component({
  selector: 'app-create-feedback',
  templateUrl: './create-feedback.component.html',
  styleUrls: ['./create-feedback.component.css']
})
export class CreateFeedbackComponent {

  feedback: Feedback = new Feedback();

  ratings: Rating [] | undefined;

  constructor(private service: FeedbackService, private router: Router) { }


  ngOnInit(): void {

    this.service.getRatingList().subscribe((data) => {
       console.log(data);
      this.ratings = data;
    });

  }

  saveEmployee() {
    this.service.createFeedback(this.feedback).subscribe(data => {
      console.log(data)
      // this.service.feedbacks.push(data);
      this.goToFeedbackList();
    })
    // error => console.log(error)
  }

  goToFeedbackList() {
    this.router.navigate(['feedbackList']);
  }


  onSelectTech(event: any) {
    this.feedback.technical_knowledge_rating = event.target.value;
  }

  onSelectWork(event: any) {
    this.feedback.work_quality_rating = event.target.value;
  }

  onSelectCom(event: any) {
    this.feedback.communication_rating = event.target.value;
  }
  onSelectTeam(event: any) {
    this.feedback.team_playing_rating = event.target.value;
  }
  onSelectOver(event: any) {
    this.feedback.overall_rating = event.target.value;
  }
}

import { Component } from '@angular/core';
// import { Feedback, Root } from '../feedback';
import { Router } from '@angular/router';
import { FeedbackService } from 'src/app/services/feedback/feedback.service';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent {
feedback_id:any;
  feedbacks: any;


  constructor(public service: FeedbackService, private router: Router) { }



  ngOnInit() {
    this.getFeedbacks();
  }

  private getFeedbacks() {
    this.service.getFeedbackList().subscribe((data: any) => {
      // console.log(26, data);
      this.feedbacks = data

      console.log(this.feedbacks);
    })
  }

  updateFeedback(feedbackid: number) {
    this.router.navigate(['/updateFeedback', feedbackid]);
  }

  // feedbackDetails(id:number){
  //   this.router.navigate(['/feedback-details', id])
  // }

  deleteFeedback(feedback_id: any) {
    this.service.deleteFeedback(feedback_id).subscribe((data:any) => {
      console.log(data);
      //this.getFeedbacks();
      window.location.reload();
    },
    (error)=>{
      console.log(error);
      
    });
  }












}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from 'src/app/model/feedback';
import { UrlConstants } from 'src/app/constants/url.constants';
import { AppConstants } from 'src/app/constants/app.constants';
import { Rating } from 'src/app/model/rating';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  // feedbacks = [];

  constructor(private http: HttpClient) { }

  public getRatingList(): Observable<Rating[]> {
    return this.http.get<Rating[]>(UrlConstants.rooturl + AppConstants.GET_RATINGLIST_API_URL);
  }

  createFeedback(feedback: any): Observable<any> {
    // console.log(18,feedback)
    return this.http.post(UrlConstants.rooturl + AppConstants.CREATE_FEEDBACK_API_URL, feedback);
  }

  getFeedbackList(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(UrlConstants.rooturl +AppConstants.GET_FEEDBACK_LIST_API_URL);
  }

  getFeedbackbyId(feedback_id: any) {
    return this.http.get(UrlConstants.rooturl +AppConstants.GET_FEEDBACK_BY_ID_API_URL + `${feedback_id}`, feedback_id);
  }

  updateFeedback(feedback_id: any, feedback: any): Observable<object> {
    return this.http.put(UrlConstants.rooturl +AppConstants.UPDATE_FEEDBACK_API_URL + `${feedback_id}`, feedback);
  }

  deleteFeedback(feedback_id: any): Observable<object> {
    return this.http.delete(UrlConstants.rooturl +AppConstants.DELETE_FEEDBACK_API_URL + feedback_id);
  }







}

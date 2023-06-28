import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rating } from 'src/app/model/rating';


@Injectable({
  providedIn: 'root'
})
export class RatingService {

  baseURL = "http://localhost:8080/feedback";

  constructor(private http: HttpClient) { }

  getRatingList(): Observable<Rating[]> {
    return this.http.get<Rating[]>(this.baseURL + "/ratings");
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { AppConstants } from 'src/app/constants/app.constants';
import { UrlConstants } from 'src/app/constants/url.constants';
@Injectable({
  providedIn: 'root'
})
export class EmpEvaluationService {

  constructor(private _http: HttpClient) { }


public getAllRating() {
  return this._http.get(UrlConstants.rooturl + AppConstants.RATING_API_URL);
}

public getAllSkill(){
  return this._http.get(UrlConstants.rooturl + AppConstants.SKILL_API_URL);
} 


public postEmployeeEvaluation(data: any, skillRating : string[]) {
return this._http.post<any>(UrlConstants.rooturl + AppConstants.EVALUATION_API_URL+"?skillRatingList="+skillRating, data);
 }

public getAllResourceIdsList(){
  return this._http.get(UrlConstants.rooturl + AppConstants.RESOURCE_ID_LIST_API_URL);
}

}


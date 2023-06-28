import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { User } from "src/app/model/user.model";
import { AppConstants } from 'src/app/constants/app.constants';
import { environment } from '../../../environments/environment';
import { UrlConstants } from 'src/app/constants/url.constants';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
    
  }

  validateLoginDetails(user: User) {
    window.sessionStorage.setItem("userdetails",JSON.stringify(user));
    return this.http.post(UrlConstants.rooturl + AppConstants.LOGIN_API_URL,user);
  }

}

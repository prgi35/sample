import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "src/app/model/user.model";
import { Observable } from 'rxjs';
import { AppConstants } from 'src/app/constants/app.constants';
import { environment } from '../../../environments/environment';
import { UrlConstants } from 'src/app/constants/url.constants';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  registerUser(user: User) : Observable<any> {
   // window.sessionStorage.setItem("userdetails",JSON.stringify(user));
    return this.http.post(UrlConstants.rooturl + AppConstants.REGISTER_API_URL, user,{responseType: 'text'});
  }
}

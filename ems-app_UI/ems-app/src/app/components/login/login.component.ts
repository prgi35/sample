import { Component, OnInit } from '@angular/core';
import { User } from "src/app/model/user.model";
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/services/login/login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  authStatus: string = "";
  errorMsg : string = "";
  successMsg : string ="";
  model = new User();

  constructor(private loginService: LoginService, private router: Router) {

   }

  ngOnInit(): void {

  }

  validateUser(loginForm: NgForm) {
    this.successMsg="";
    this.errorMsg="";
    this.loginService.validateLoginDetails(this.model).subscribe(
      responseData => {
        console.log("User Details :"+this.model.name);
        if(responseData != null){
          this.model = <any>responseData;
          console.log("Log : "+this.model.authErrorMsg);
          if(this.model.authErrorMsg === "Invalid"){

            this.errorMsg="Invalid Password..!";
            this.router.navigate(['login']);
          }else{
            this.model.authStatus = 'AUTH';
            window.sessionStorage.setItem("userdetails",JSON.stringify(this.model));
            this.router.navigate(['dashboard']);
          }
          
        }else {
          this.errorMsg="User Not Found";
          this.router.navigate(['login']);
        }
        
      });

  }

}

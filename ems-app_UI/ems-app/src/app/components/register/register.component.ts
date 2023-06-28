import { Component, OnInit } from '@angular/core';
import { User } from "src/app/model/user.model";
import { NgForm } from '@angular/forms';
import { RegisterService } from 'src/app/services/register/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
 
  errorMsg : string = "";
  successMsg : string ="";
  model = new User();

  constructor(private registerService: RegisterService, private router: Router) {

   }

  ngOnInit(): void {

  }

  registerUser(registerForm: NgForm) {
    this.successMsg="";
    this.errorMsg="";
    this.registerService.registerUser(this.model).subscribe(
      responseData => {
        console.log("Responce : "+responseData);
        if (responseData === 'Exist') {
          this.errorMsg = "Email Id is already registered !";
          console.log("User Not Register : "+responseData);    
          this.router.navigate(['register']);
        }else if (responseData === 'Error') {
          this.errorMsg = "Internal Errror !";
          console.log("Something wroung : "+responseData);   
          registerForm.resetForm();
          this.router.navigate(['register']);
        } else {
          this.successMsg = "User Registration succsesfully Done !";
          console.log("Register Done: "+responseData);   
          registerForm.resetForm();
          this.router.navigate(['register']);
        }
        
      });

  }

}
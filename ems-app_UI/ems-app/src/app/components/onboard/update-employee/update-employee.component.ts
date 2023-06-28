import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OnboardService } from 'src/app/services/onboard/onboard.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit{

  employeeId: any;
  employee: any;

  constructor(private _onboard: OnboardService, private _route: ActivatedRoute, private router:Router) { }

  ngOnInit(): void {
    this.employeeId = this._route.snapshot.params['employeeId'];
    //console.log("hhhhhhhhh :"+this.employeeId);
    this._onboard.getEmployeeById(this.employeeId).subscribe((data: any) => {
      console.log(data);
      this.employee = data;
     // console.log("iiiiiiiiiii"+this.employee);
      
    },
      (error) => {
        console.log(error);
      });
  }

  updateData() {
    this._onboard.updateEmployee(this.employee,this.employeeId).subscribe((data: any) => {
      console.log(data)
      this.employee = data;
      console.log("hhhhhhhhhhhh"+this.employee);
      this.router.navigate(['/onboard/view']);
    },
      (error) => {
        console.log(error);

      });
  }

}

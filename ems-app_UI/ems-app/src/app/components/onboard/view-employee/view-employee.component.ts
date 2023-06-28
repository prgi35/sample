import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { employee } from 'src/app/model/employee.model';
import { OnboardService } from 'src/app/services/onboard/onboard.service';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit{
  
  
  employee: employee[];
  constructor(private _onboardService: OnboardService, private router : Router) { }

  ngOnInit(): void {
    this._onboardService.getAllEmployee().subscribe((data: any) => {
      //console.log(data);
      this.employee = data;
      console.log(this.employee);
    },
      (error) => {
        console.log(error);
      });
  }

  deleteEmployee(employeeId: any) {
    this._onboardService.deleteEmployee(employeeId).subscribe((data: any) => {
      console.log(data);
      window.location.reload();
    },
      (error) => {
        console.log(error);
      });
    //alert("delete function call");
  }
  updateEmployee(employeeId : number){
    console.log(employeeId+"update works");
    this.router.navigate(['onboard/update/',employeeId]);
   

  }

}

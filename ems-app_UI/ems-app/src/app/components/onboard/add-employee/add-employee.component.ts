import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { OnboardService } from 'src/app/services/onboard/onboard.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {
  //emp!:FormGroup;
  emp = new FormGroup({
    employeeId: new FormControl(''),
    yashEmpId: new FormControl(''),
    employeeName: new FormControl(''),
    grade: new FormControl(''),
    designation: new FormControl(''),
    email: new FormControl(''),
    dateOfJoining: new FormControl(''),
    baseLocation: new FormControl(''),
    currentLocation: new FormControl(''),
    primarySkills: new FormControl(''),
    secondarySkills: new FormControl(''),
    exprience: new FormControl(''),
    mobileNo: new FormControl(''),
    irm: new FormControl(''),
  })
  submitted = false;
  constructor(private _onboardService: OnboardService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit() {
    //validations

    this.formBuilder.group({
      yashEmpId:  ['', Validators.required],
      employeeName: ['', Validators.required],
      grade: ['', Validators.required],
      designation: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      dateOfJoining: ['', Validators.required],
      baseLocation: ['', Validators.required],
      currentLocation: ['', Validators.required],
      primarySkills: ['', Validators.required],
      secondarySkills: ['', Validators.required],
      exprience: ['', Validators.required],
      mobileNo: ['', [Validators.required, Validators.maxLength]]
    })
  }

  saveEmployee() {
    this._onboardService.addEmployee(this.emp.value).subscribe((data: any) => {
      console.log(this.emp.value);
      this.router.navigate(['/onboard/view']);
    });
  }

  onSubmit() {
    this.saveEmployee();

  }

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OnboardService {

  baseURL = "http://localhost:8080/employee"
  constructor(private _http: HttpClient) { }

  //add Employee
  public addEmployee(employee: any) {
    console.log(employee);
    return this._http.post(this.baseURL + "/addEmp", employee);
  }
  //get All Employee Details
  public getAllEmployee() {
    return this._http.get(this.baseURL + "/getAllEmp/");
  }
  //update Employee
  public updateEmployee(employee: any, employeeId: any) {
    return this._http.put(this.baseURL + "/updateEmp/" + `${employeeId}`, employee);
  }
  //delete Employee
  public deleteEmployee(employeeId: any) {
    return this._http.delete(this.baseURL + "/deleteEmp/" + employeeId);
  }
  //get Employee By Id
  public getEmployeeById(employeeId: any) {
    return this._http.get(this.baseURL + "/getEmp/" + `${employeeId}`, employeeId);
  }


}

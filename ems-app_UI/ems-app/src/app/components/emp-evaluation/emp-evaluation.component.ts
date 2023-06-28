import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { EmpEvaluationService } from 'src/app/services/evaluation/emp-evaluation.service';

@Component({
  selector: 'app-emp-evaluation',
  templateUrl: './emp-evaluation.component.html',
  styleUrls: ['./emp-evaluation.component.css']
})
export class EmpEvaluationComponent implements OnInit {
  currentDateTime: any;
  skillList: any[] = [];
  ratingList: any[] = [];
  skillRatingId : string[] = [];
  resourceEmpIdList : string[] = [];

  constructor(private fb: FormBuilder, public datepipe: DatePipe, private empEvlServ: EmpEvaluationService) {
    this.currentDateTime = this.datepipe.transform((new Date), 'MM/dd/yyyy');
    //this.currentDateTime = new Date();
    this.currentDateTime = new Date();
    console.log("Current Date : " + this.currentDateTime);
  }
  getCurrentDate() {
    return this.currentDateTime;
  }

  evaluationForm!: FormGroup;

  namepattern = "^[a-zA-z ]{2,15}$";
  
  ngOnInit(): void {

    this.empEvlServ.getAllResourceIdsList().subscribe((res : any) => {
      console.log("Resource Id List : "+res);
      this.resourceEmpIdList = res;
      console.log("Resorce Data Id List : "+this.resourceEmpIdList);
    },
      (error) => {
        console.log(error);
      });

    this.empEvlServ.getAllRating().subscribe((data: any) => {
      this.ratingList = data;
      if (this.ratingList.length > 0) {
        this.empEvlServ.getAllSkill().subscribe((data: any) => {
          this.skillList = data;
          if (this.skillList.length > 0) {
            this.skillList.forEach(skill => {
              let forControl = skill.skillName + "_FormControl_" + skill.skill_id;
              skill["formControl"] = forControl;
              skill[forControl] = new FormControl("", Validators.required);
              this.evaluationForm.addControl(forControl, new FormControl("", Validators.required));
              skill['ratingList'] = this.ratingList;
            });
          }
        },
          (error) => {
            console.log(error);
          });
      }
    },
      (error) => {
        console.log(error);
      });


    console.log(this.skillList);
    this.evaluationForm = this.fb.group({
      empEvaluationId: ['', [Validators.required]],
      evaluationDate: [(new Date()).toISOString().substring(0, 10), [Validators.required]],
      evaluationNumber : ['', [Validators.required]],
      evaluatedBy: ['', [Validators.required]],
      overallRating: ['', [Validators.required]],
      remarks: ['', [Validators.required]],
    });
  }

  getFormControl(data) {
    return data.formControl;
  }
  onSubmit() {
    {
      console.log(this.evaluationForm.value);
      let obj = [];
      this.skillList.forEach(s => {
        let ratingId = Number.parseInt(this.evaluationForm.value[s.skillName + "_FormControl_" + s.skill_id]);
        let skillId = s.skill_id;
        this.skillRatingId.push(skillId+"_"+ratingId);
      });
      console.log("Array Of Skill : "+this.skillRatingId);
      let overallRatingObj = this.ratingList.filter(r => {
        if (r.ratingId === Number(this.evaluationForm.value['overallRating'])) {
          return r
        }
      });
      console.log("OBJ dat : "+obj);
      
      this.empEvlServ.postEmployeeEvaluation(this.evaluationForm.value,this.skillRatingId).subscribe((data: any) => {

        alert("Data Saved")
        let ref = document.getElementById('cancel')
        ref?.click();
        this.evaluationForm.reset();
      });


    }
  }

}

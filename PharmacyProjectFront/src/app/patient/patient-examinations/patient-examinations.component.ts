import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { DermatologistExaminations } from 'src/app/model/dermatologistExamination';
import { UserService } from 'src/app/service';
import { PatientService } from 'src/app/service/patient.service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './patient-examinations.component.html'

})

export class PatientExaminationComponent implements OnInit {

    user: User;
    request!: Request;
    examinations:DermatologistExaminations[];
    examination:Object;
   
  
    constructor(private router: Router, private loginService: LoginService,private userService:UserService,private patientService: PatientService) {
        this.user = new User();
       this.examinations=[];
       this.examination=new Object();
       
      }
      ngOnInit(): void {
       this.getUser();
       
      }
      //*******VRACA SVE PREGLEDE *******
      getExaminationsByPatient(){
        this.patientService.getExaminationsByPatient(this.user.id).subscribe({
            next: cons=>
            {
                this.examinations=cons;
                console.log(this.examinations);
            }
        })
      }

      //**********OTKAZIVANJE PREGLEDA */
      cancelExamination(examinationId:number){
        this.patientService.cancelExamination(examinationId).subscribe({
          next: cons=>{
            this.examination=cons;
           
            if(this.examination==null){
              alert("Reservation can be canceled up to 24h before!");
          } else{
              alert("Reservation successfully canceled!");
          }
          }
        })
      }


      //**********SORTIRANJE *******/
      sort(sortType: string) {
        console.log(sortType);
        this.patientService.sortExaminations(this.examinations, sortType).subscribe({
            next: ex => {
                this.examinations = ex;
            }

        });
    }

    

      getUser() {
    
        this.loginService.getLoggedUser().subscribe({
          next: t => {
            this.user = t;
            console.log(this.user.city);
            this.getExaminationsByPatient();
          }
    
        });
    
      }
      
      logout(): void {
        this.loginService.logout(this.request).subscribe(result => this.redirect());
        localStorage.removeItem(USER_ID_KEY);
        localStorage.removeItem(USER_ROLE_KEY);
        localStorage.removeItem(USERNAME_KEY);
        localStorage.removeItem(USER_TOKEN_KEY);

        
        alert('Logged out!');
      }
      
      redirect() {
        this.router.navigate(["/homepage"]);
      }

  }

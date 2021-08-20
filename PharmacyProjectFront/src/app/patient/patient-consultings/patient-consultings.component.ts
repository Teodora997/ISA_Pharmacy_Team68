import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Consulting } from 'src/app/model/consulting';
import { Medicine } from 'src/app/model/medicine';
import { UserService } from 'src/app/service';
import { PatientService } from 'src/app/service/patient.service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './patient-consultings.component.html'

})

export class PatientConsultingComponent implements OnInit {

    user: User;
    request!: Request;
    consultings:Consulting[];
    consulting:Object;
  
    constructor(private router: Router, private loginService: LoginService,private userService:UserService,private patientService: PatientService) {
        this.user = new User();
       this.consultings=[];
       this.consulting=new Object();
      }
      ngOnInit(): void {
       this.getUser();
       
      }
      //*******VRACA SVE PREGLEDE *******
      getConsultingsByPatient(){
        this.patientService.getConsultingsByPatient(this.user.id).subscribe({
            next: cons=>
            {
                this.consultings=cons;
                console.log(this.consultings);
            }
        })
      }

      //**********OTKAZIVANJE PREGLEDA */
      cancelConsulting(consultingId:number){
        this.patientService.cancelConsulting(consultingId).subscribe({
          next: cons=>{
            this.consulting=cons;
            if(this.consulting==null){
              alert("Reservation can be canceled up to 24h before!");
          } 
              alert("Reservation successfully canceled!");
          
          }
        })
      }


      getUser() {
    
        this.loginService.getLoggedUser().subscribe({
          next: t => {
            this.user = t;
            console.log(this.user.city);
            this.getConsultingsByPatient();
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

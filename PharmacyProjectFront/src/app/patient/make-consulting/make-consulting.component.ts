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
  templateUrl: './make-consulting.component.html'

})

export class MakeConsultingComponent implements OnInit {

    user: User;
    request!: Request;
    times: String[];
    date:Date;
    time:String;
    pharmacies:Consulting[];
    d:Date;
    penalties:number=0;
  
    constructor(private router: Router, private loginService: LoginService,private userService:UserService,private patientService: PatientService) {
        this.user = new User();
        this.times=[];
        this.date=new Date;
        this.time="";
        this.pharmacies=[];
        this.date=new Date();
        this.d=new Date();
      }
      ngOnInit(): void {
       this.getUser();
       this.times=["8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30","16:00"];
      }
     
      getMyPenalties(){
        this.patientService.getMyPenalty(this.user.id).subscribe({
          next: p=>{
            this.penalties=p;
          }
        })
      }
      //******** Nalazi dostupne preglede *******
      getPharmaciesForConsulting()
      {
        let d1=new Date(this.date);
        let d2=new Date();
        if(d1<d2){
          alert("Choose valid date!");
        }else{

        console.log("Trazi slobodne apoteke za pregled kod farmaceuta");
        this.patientService.getPharmaciesForConsulting(this.date,this.time).subscribe({
            next: pharmacies=>
                {
                    this.pharmacies=pharmacies;
                    if(pharmacies==null){
                        alert("No available consultings!")
                    }
                    console.log("Trazi slobodne apoteke za pregled kod farmaceuta");
                }

        });
      }
      }
            //******** REZERVISE PREGLED KOD Farmaceuta *******
            makeConsulting(consultingId: number){
              if(this.penalties>=3){
                alert("You have "+this.penalties+" penals,so you can't reserve consulting!");
              }else{
                this.patientService.makeConsulting(consultingId,this.user.id).subscribe({
                next: exId=>{
                  console.log(exId)
                    if(exId==null){
                      alert("Not succesifull!Patient already has consulting/examination for this date and time!")
                    }else{
                    alert("Consulting scheduled!");
                    }
                }
                })
              }
            }

      getUser() {
    
        this.loginService.getLoggedUser().subscribe({
          next: t => {
            this.user = t;
            console.log(this.user.city);
            this.getMyPenalties();
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

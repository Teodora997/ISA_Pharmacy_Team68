import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Consulting } from 'src/app/model/consulting';
import { DermatologistExaminations } from 'src/app/model/dermatologistExamination';
import { Medicine } from 'src/app/model/medicine';
import { Pharmacy } from 'src/app/model/pharmacy';
import { UserService } from 'src/app/service';
import { PatientService } from 'src/app/service/patient.service';
import { User } from 'src/app/user';




@Component({
  templateUrl: './patient-complaint.component.html'

})

export class PatientComplaintComponent implements OnInit {

    user: User;
    request!: Request;
    consultings: Consulting[]=[];
    examinations: DermatologistExaminations[]=[];
    complaintText!:string;
    previewText!: boolean;
    previewTextP!: boolean;
    userId!:number;
    pharmacyId!:number;
    consultings1: Consulting[]=[];
    examinations1: DermatologistExaminations[]=[];
    pharmacies:Pharmacy[]=[];
    
    constructor(private router: Router, private loginService: LoginService,private userService:UserService,private patientService: PatientService) {
        this.user = new User();
       this.previewText=false;
       this.previewTextP=false;
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

                for(let c of this.consultings){
                  if(c.examinationStatus=="done"){
                    this.consultings1.push(c);
                  }
                }
                console.log(this.consultings);
            }
        })
      }
      getExaminationsByPatient(){
        this.patientService.getExaminationsByPatient(this.user.id).subscribe({
            next: cons=>
            {
                this.examinations=cons;
                for(let c of this.examinations){
                  if(c.examinationStatus=="done"){
                    this.examinations1.push(c);
                  }
                }
                console.log(this.examinations);
            }
        })
      }

      getPharmacies(){
        this.patientService.getPharmaciesForComplaint(this.user.id).subscribe({
          next: cons=>
          {
              this.pharmacies=cons;
              
              console.log(this.pharmacies);
          }
      })
      }

      writeComplaint(pharmacistId:number){
        console.log(pharmacistId);
        this.previewText=!this.previewText;
        this.complaintText="";
        this.userId=pharmacistId;
        console.log(this.userId);
        
        
      }

      writeComplaintPharmacy(pharmacyId:number){
        console.log(pharmacyId);
        this.previewTextP=!this.previewTextP;
        this.complaintText="";
        this.pharmacyId=pharmacyId;
        console.log(this.pharmacyId);
        
        
      }
 
      sendComplaint(){
        if(this.complaintText==""){
          alert("Can not send empty complaint");
        }
        this.patientService.makeComplaint(this.user.id,this.userId,this.complaintText).subscribe({
          next: c=>
          {
              if(c==null){
                alert("Something went wrong");
              }else{
                alert("Complaint is sent");
              }

          }
      })

      }

      sendComplaintPharmacy(){
        if(this.complaintText==""){
          alert("Can not send empty complaint");
        }
        this.patientService.makeComplaintPharmacy(this.user.id,this.pharmacyId,this.complaintText).subscribe({
          next: c=>
          {
              if(c==null){
                alert("Something went wrong");
              }else{
                alert("Complaint is sent");
              }
 
          }
      })

      }

      getUser() {
        
        this.loginService.getLoggedUser().subscribe({
          next: t => {
            this.user = t;
            console.log(this.user.city);
            this.getConsultingsByPatient();
            this.getExaminationsByPatient();
            this.getPharmacies();
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

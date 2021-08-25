import { Component, OnInit } from '@angular/core';
import { Routes, Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Consulting } from 'src/app/model/consulting';
import { DermatologistExaminations } from 'src/app/model/dermatologistExamination';
import { Medicine } from 'src/app/model/medicine';
import { MedicineForReservation } from 'src/app/model/medicineForReservation';
import { Pharmacy } from 'src/app/model/pharmacy';
import { UserService } from 'src/app/service';
import { MedicineService } from 'src/app/service/medicine.service';
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
    mark:string;
    marks:string[]=[];
    s!: number;
    medicines:MedicineForReservation[]=[];
    medicines1:MedicineForReservation[]=[];
    
    constructor(private router: Router, private loginService: LoginService,private userService:UserService,private patientService: PatientService,private medicineService: MedicineService) {
        this.user = new User();
       this.previewText=false;
       this.previewTextP=false;
       this.mark="";
       this.marks=["0","1","2","3","4","5","6","7","8","9","10"];
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
      //******* OCJENJIVANJE *********/
      rateUser(userId:number){
        console.log(userId);
        this.patientService.rateUser(userId,this.mark).subscribe({
          next: s=>{
            this.s=s;
            console.log(this.s);
          }
        });
      }
      ratePharmacy(pharmacyId:number){
        console.log(pharmacyId);
        this.patientService.ratePharmacy(pharmacyId,this.mark).subscribe({
          next: s=>{
            this.s=s;
            console.log(this.s);
          }
        })
      }

      getReservationsByPatient(){
        this.medicineService.getReservationsByPatient(this.user.id).subscribe({
            next: res=>{
                this.medicines=res;
                for(let r of this.medicines){
                  if(r.status=="DONE"){
                    this.medicines1.push(r);
                  }
                }
            }
        })
    }
    rateMedicine(medicineId:number){
      this.patientService.rateMedicine(medicineId,this.mark).subscribe({
        next: s=>{
          this.s=s;
          console.log(this.s);
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
            this.getReservationsByPatient();
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

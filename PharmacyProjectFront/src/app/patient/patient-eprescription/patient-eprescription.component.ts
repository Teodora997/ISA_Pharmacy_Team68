import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { HttpClient } from "@angular/common/http";
import { Pharmacy } from "src/app/model/pharmacy";
import { PharmacyService } from "src/app/service/pharmacy.service";
import { LoginService } from "src/app/login/login.service";
import { User } from "src/app/user";
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from "src/app/config/localStorageKeys";
import { DermatologistExaminations } from "src/app/model/dermatologistExamination";
import { PatientService } from "src/app/service/patient.service";
import { Medicine } from "src/app/model/medicine";
import { MedFromQR } from "src/app/model/medFromQR";
import { AvailabilityEPrescription } from "src/app/model/availabilityEprescription";


@Component({
    templateUrl: './patient-eprescription.component.html'
})

export class PatientEprescriptionComponent implements OnInit {
    
    id!: number;
    user:User;
    request!: Request;
    response: AvailabilityEPrescription;
    r!:number;
    files: any[];
   

    constructor(private router: Router, private pharmacyService: PharmacyService,private route: ActivatedRoute,private loginService:LoginService,private patientService:PatientService) {
        
        this.user = new User();
        this.files = [];
        this.response=new AvailabilityEPrescription();
       }
    ngOnInit(): void {
        this.getUser();
       
    }
    
    onFileChanged(event: any) {
      this.files = event.target.files;
    } 
    
    onUpload() {
      const formData = new FormData();
      for (const file of this.files) {
          formData.append("file", file, file.name);
      }
      this.patientService.getEprescription(this.user.id,formData).subscribe({
        next: t => {
          this.response = t;
          if(this.response.pharmacies==null){
            alert("There is no pharmacy with this medicines!");
          }
        }
  
      });
    }

    buy(pharmacyId:number,prescriptionId:number){
      this.patientService.buyEprescription(pharmacyId,prescriptionId).subscribe({
        next: t => {
          this.r = t;

          
            alert("Succesufully!"); 
          
            this.refresh(); 
                   
          }
  
      });

    }
    //****** NALAZI ULOGOVANOG ********
    getUser() {
    
        this.loginService.getLoggedUser().subscribe({
          next: t => {
            this.user = t;
            console.log(this.user.city);
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
      refresh() {
        window.location.reload();
         
    }
}

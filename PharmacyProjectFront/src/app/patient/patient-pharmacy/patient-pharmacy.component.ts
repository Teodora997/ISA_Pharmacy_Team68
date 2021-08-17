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


@Component({
    templateUrl: './patient-pharmacy.component.html'
})

export class PatientPharmacyComponent implements OnInit {
    pharmacy: Pharmacy;
    id!: number;
    user:User;
    request!: Request;
    availableExaminations:DermatologistExaminations[];
    

    constructor(private router: Router, private pharmacyService: PharmacyService,private route: ActivatedRoute,private loginService:LoginService,private patientService:PatientService) {
        this.pharmacy=new Pharmacy();
        this.user = new User();
        this.availableExaminations=[];
       }
    ngOnInit(): void {
        this.getUser();
        const param = this.route.snapshot.paramMap.get('id');
        if (param) {
            this.id = +param;
            this.getPharmacy(this.id);
            
        }
    }
    getPharmacy(id:number){
        this.pharmacyService.getPharmacy(id).subscribe({
            next: pharmacy => {
                this.pharmacy = pharmacy;
                this.getAvailableExaminations();
            }
        }
        );
    }

    //********DOSTUPNI PREGLEDI *********
    getAvailableExaminations(){
      console.log("PRONALAZI DOSTUPNE PREGLEDE");
      this.patientService.getAvailableExaminations(this.pharmacy.id).subscribe(
        {
          next: examinations =>{
            this.availableExaminations=examinations;
          }
        }
      );

    }
    //******** REZERVISE PREGLED KOD DERMATOLOGA ********
    makeExamination(examinationId: number){
      this.patientService.makeExamination(examinationId,this.user.id).subscribe({
        next: exId=>{
          if(exId==null){
            alert("Not succesifull")
          }else{
            window.location.reload();
            alert("Examination scheduled!");
          }
        }
      })
      //window.location.reload();
      //alert("Examination scheduled!");
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
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Medicine } from 'src/app/model/medicine';
import { MedicineForReservation } from 'src/app/model/medicineForReservation';
import { Pharmacy } from 'src/app/model/pharmacy';
import { PharmacyAndPriceForMedicine } from 'src/app/model/pharmacyAndPriceForMedicine';
import { MedicineService } from 'src/app/service/medicine.service';
import { PatientService } from 'src/app/service/patient.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { User } from 'src/app/user';



@Component({
  templateUrl: './medicine-reservation.component.html'
})

export class MedicineReservationComponent implements OnInit {
  
  allMedicines : Medicine[] = [];  
  searchParameter!: string;
  filterParameter!:string;
  user: User;
  request!: Request;
  selectedMedicine: Medicine;
  previewDescription! :boolean;
  previewPharmacies!:boolean;
  pharmacies: MedicineForReservation[]=[];
  reservations:MedicineForReservation[]=[];
  d!: String;
  d1!:Date;
  penalties:number=0;

  constructor(private router: Router,private medicineService:MedicineService, private pharmacyService: PharmacyService,private loginService:LoginService,private patientService:PatientService) {
    this.selectedMedicine=new Medicine();
    this.user=new User();
    this.previewDescription=false;
    this.previewPharmacies=false;
    this.d1=new Date();
  
   }

ngOnInit(): void {
    this.getUser();
    this.medicineService.getAllMedicines().subscribe({
        next: m => {
            this.allMedicines = m;
            
        }

    });

}
pretraga(){
  console.log(this.searchParameter);
  let sp = "";
        if(this.searchParameter== undefined){
            sp = "all";
        } else {
            sp= this.searchParameter;
        }

        console.log(this.searchParameter);
        console.log(sp);

        this.medicineService.searchMedicines(sp).subscribe({
            next: m => {
                this.allMedicines = m;
            }

        });
}

filter(){
  console.log(this.filterParameter);
  let sp = "";
        if(this.filterParameter== undefined){
            sp = "all";
        } else {
            sp= this.filterParameter;
        }

        console.log(this.filterParameter);
        console.log(sp);

        this.medicineService.filterMedicines(sp,this.allMedicines).subscribe({
            next: m => {
                this.allMedicines = m;
            }

        });
}

seeDescription(m:Medicine) {
  this.previewDescription = !this.previewDescription;

  this.selectedMedicine=m;
}

//******APOTEKE U KOJIM JE LIJEK DOSTUPAN */
seePharmacies(m:Medicine){
  this.previewPharmacies=!this.previewPharmacies;

  this.pharmacyService.getPharmaciesForMedicineReservation(m.id).subscribe({
    next: p => {
      this.pharmacies = p;
      console.log(this.pharmacies);

    }

  });
}
//*******VRACA SVE REZERVACIJE LIJEKA ZA PACIJENTA */
getReservationsByPatient(){
    this.medicineService.getReservationsByPatient(this.user.id).subscribe({
        next: res=>{
            this.reservations=res;
        }
    })
}

//********REZERVISE LIJEK    ******/
makeReservation(med:MedicineForReservation){
    let d1=new Date(med.date);
    let d2=new Date();
    if(d1<d2){
        alert("Choose valid date!");
     }else if(this.penalties>=3){
        alert("You have "+this.penalties+" penals,so you can't reserve medicine!");
      }else{
    console.log(this.d);
    this.medicineService.makeReservation(med,this.user.id).subscribe({
        next: r=>{
            if(r==null){
                alert("Not succesifull! \n No available medicine in pharmacy storage!");
            }else{
                alert("Medicine reserved!");
            }
        }
    })
}
}
//*********OTKAZIVANJE REZERVACIJE LIJEKA */
cancelReservation(r:MedicineForReservation){
    
    if(r.status=="CANCELED" || r.status=="DONE"){
        alert("Already canceled or done");
    }else{
    this.medicineService.cancelReservation(r).subscribe({
        next: res=>{
            if(res==null){
                alert("Reservation can be canceled up to 24h before!");
            }else{
                alert("Canceled reservation");
            }
        }
    })
}
}
getMyPenalties(){
    this.patientService.getMyPenalty(this.user.id).subscribe({
      next: p=>{
        this.penalties=p;
      }
    })
  }
getUser() {
    
    this.loginService.getLoggedUser().subscribe({
      next: t => {
        this.user = t;
        console.log(this.user.city);
        this.getReservationsByPatient();
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
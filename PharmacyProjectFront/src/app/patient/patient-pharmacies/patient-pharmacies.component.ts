import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SearchPharmacy } from 'src/app/model/searchPharmacy';
import { PatientService } from 'src/app/service/patient.service';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { User } from 'src/app/user';

@Component({
  selector: 'patient-pharmacies',
  templateUrl: './patient-pharmacies.component.html'
})

export class PatientPharmaciesComponent implements OnInit {
  allPharmacies : Pharmacy[] = [];
  ph!: Pharmacy;
  filteredPharmacies : Pharmacy[] = [];
  subscribedPharmacies : Pharmacy[] = [];
  previewSearch:boolean;  
  searchParameters: SearchPharmacy;
  user: User;
  request!: Request;

  constructor(private router: Router, private pharmacyService: PharmacyService,private loginService:LoginService,private patientService: PatientService) {
    this.searchParameters = new SearchPharmacy();
    this.previewSearch=false;
    this.user=new User();
   }

ngOnInit(): void {
    this.getUser();
    this.pharmacyService.getAllPhamracies().subscribe({
        next: pharmacies => {
            this.allPharmacies = pharmacies;
            this.filteredPharmacies=this.allPharmacies;
        }

    });

}
//******VRACA APOTEKE NA KOJE JE PACIJENT PRETPLACEN */
getSubscribedPharmacies(){
  this.patientService.getSubscribedPharmacies(this.user.id).subscribe({
    next: subs=>{
      this.subscribedPharmacies=subs;
    }
  })
}

//*********PRETPLATA NA ODABRANU APOTEKU */
subscribe(pharmacyId:number){
  this.patientService.subscribe(this.user.id,pharmacyId).subscribe({
    next: p=>{
      this.ph=p;
      if(this.ph==null){
        alert("Already subscribed!");
      }else{
      alert("Succesifully subscribed!");
    }
  }
  })
}
unsubscribe(pharmacyId:number){
  this.patientService.unsubscribe(this.user.id,pharmacyId).subscribe({
    next: p=>{
      this.ph=p;
      alert("Succesifully unsubscribed!");
    }
  })
}

filter(){
  this.filteredPharmacies=[];
  for(let p of this.allPharmacies){
    
    if(this.searchParameters.markFrom.toString()==" " && this.searchParameters.markTo.toString()==" "){
      this.filteredPharmacies=this.allPharmacies;
     }else if(p.mark>=this.searchParameters.markFrom && p.mark<=this.searchParameters.markTo){
      this.filteredPharmacies.push(p);
    }
  }
}
pretraga(){
  console.log(this.searchParameters.name);
  let sp = new SearchPharmacy();
        if(this.searchParameters.name == undefined){
            sp.name = "all";
        } else {
            sp.name = this.searchParameters.name;
        }

        if(this.searchParameters.address == undefined){
            sp.address = "all";
        } else {
            sp.address = this.searchParameters.address;
        }


        console.log(this.searchParameters);
        console.log(sp);

        this.pharmacyService.searchPharmacies(sp).subscribe({
            next: pharmacies => {
                this.filteredPharmacies = pharmacies;
            }

        });
}
getUser() {
    
    this.loginService.getLoggedUser().subscribe({
      next: t => {
        this.user = t;
        this.getSubscribedPharmacies();
        console.log(this.user.firstName);
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
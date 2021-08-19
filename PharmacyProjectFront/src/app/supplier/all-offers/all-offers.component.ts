import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SearchPharmacy } from 'src/app/model/searchPharmacy';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { User } from 'src/app/user';

@Component({
  selector: 'all-offers',
  templateUrl: './all-offers.component.html'
})

export class AllOffersComponent implements OnInit {
  allPharmacies : Pharmacy[] = [];
  previewSearch:boolean;  
  searchParameters: SearchPharmacy;
  user: User;
  request!: Request;

  constructor(private router: Router, private pharmacyService: PharmacyService,private loginService:LoginService) {
    this.searchParameters = new SearchPharmacy();
    this.previewSearch=false;
    this.user=new User();
   }

ngOnInit(): void {
    this.getUser();
    this.pharmacyService.getAllPhamracies().subscribe({
        next: pharmacies => {
            this.allPharmacies = pharmacies;
            
        }

    });

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

        if(this.searchParameters.markFrom == undefined){
           sp.markFrom = -123456789;
        } else {
            sp.markFrom = this.searchParameters.markFrom;
        }

        if(this.searchParameters.markTo == undefined){
            sp.markTo = 123456789;
        } else {
            sp.markFrom = this.searchParameters.markFrom;
        }


        console.log(this.searchParameters);
        console.log(sp);

        this.pharmacyService.searchPharmacies(sp).subscribe({
            next: pharmacies => {
                this.allPharmacies = pharmacies;
            }

        });
}
getUser() {
    
    this.loginService.getLoggedUser().subscribe({
      next: t => {
        this.user = t;
        console.log(this.user.city);
      }

    });

  }
  
  
  redirect() {
    this.router.navigate(["/homepage"]);
  }
}
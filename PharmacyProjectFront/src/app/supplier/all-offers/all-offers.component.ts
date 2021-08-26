import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { DisplayOffer } from 'src/app/model/displayOffer';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SearchPharmacy } from 'src/app/model/searchPharmacy';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { SupplierService } from 'src/app/service/supplier.service';
import { User } from 'src/app/user';

@Component({
  selector: 'all-offers',
  templateUrl: './all-offers.component.html'
})

export class AllOffersComponent implements OnInit {
  
  user: User;
  request!: Request;
  offers: DisplayOffer[]=[];

  constructor(private router: Router, private supplierService: SupplierService,private loginService:LoginService) {
   
    this.user=new User();
   }

ngOnInit(): void {
    this.getUser();
  

}
getOffers(){
  this.supplierService.getOffers(this.user.id).subscribe({
    next: t => {
      this.offers = t;
    }

  });
}
getUser() {
    
    this.loginService.getLoggedUser().subscribe({
      next: t => {
        this.user = t;
        console.log(this.user.city);
          this.getOffers(); 
      }

    });

  }
  
  
  redirect() {
    this.router.navigate(["/homepage"]);
  }
}
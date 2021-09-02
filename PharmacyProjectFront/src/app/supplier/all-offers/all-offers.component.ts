import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { DisplayOffer } from 'src/app/model/displayOffer';
import { Offer } from 'src/app/model/offer';
import { Order } from 'src/app/model/order';
import { OrderItem } from 'src/app/model/orderItem';
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
  previewChangeOffer:boolean;
  offer:DisplayOffer;
  orderItems:OrderItem[]=[];
  order : Order;
  response!:any;
  offer1:Offer;
  

  constructor(private router: Router, private supplierService: SupplierService,private loginService:LoginService) {
   
    this.user=new User();
    this.previewChangeOffer=false;
    this.offer=new DisplayOffer();
    this.order=new Order();
    this.offer1=new Offer();
    
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

changeOffer(o:DisplayOffer){
  this.offer=o;
  

  this.previewChangeOffer = !this.previewChangeOffer;
  this.supplierService.getItemsFromOrder(this.offer.orderId).subscribe({
    next: t => {
      this.orderItems = t;
      //console.log(this.orders);
    }

  }); 

}

sendOffer(){

  this.offer.totalPrice=this.offer1.totalPrice;
  this.offer.deliveryDate=this.offer1.deliveryDate;
  
  let d1=new Date();
  let d2=new Date(this.offer.deliveryDate);
  let d3=new Date(this.offer.timeLimit);
  if(this.offer.deliveryDate==null || this.offer.totalPrice==null){
    alert("Fields cant be empty!");
  }else{
 
  if(d2<d1){
    alert("Delivery date must be after today!");
  }else{
  if(d2>d3){
    alert("Changing offer cant be after time limit of order!");
  }else{
  console.log(this.offer);
  this.supplierService.changeOffer(this.user.id,this.offer.orderId,this.offer).subscribe({
    next: t => {
      this.response = t;
      alert("Offer is changed!");
      this.refresh();
    }

  });
}
}
}
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
  refresh() {
    window.location.reload();
}
  
  redirect() {
    this.router.navigate(["/homepage"]);
  }
}
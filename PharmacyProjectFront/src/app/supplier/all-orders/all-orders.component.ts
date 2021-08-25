import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from 'src/app/config/localStorageKeys';
import { LoginService } from 'src/app/login/login.service';
import { Offer } from 'src/app/model/offer';
import { Order } from 'src/app/model/order';
import { OrderItem } from 'src/app/model/orderItem';
import { Pharmacy } from 'src/app/model/pharmacy';
import { SearchPharmacy } from 'src/app/model/searchPharmacy';
import { PharmacyService } from 'src/app/service/pharmacy.service';
import { SupplierService } from 'src/app/service/supplier.service';
import { User } from 'src/app/user';

@Component({
  selector: 'all-orders',
  templateUrl: './all-orders.component.html'
})

export class AllOrdersComponent implements OnInit {
 
  previewOrderItems:boolean;  
  previewOffer:boolean; 
  user: User;
  orders: Order[]=[];
  orderItems: OrderItem[]=[]; 
  order : Order;
  offer : Offer;
  response:any;

  constructor(private router: Router, private supplierService: SupplierService,private pharmacyService: PharmacyService,private loginService:LoginService) {
   
    this.previewOrderItems=false;
    this.previewOffer=false;
    this.order=new Order();
    this.user=new User();
    this.offer=new Offer();

   }

ngOnInit(): void {
    this.getUser();
    this.getOrders();

}

sendOffer(){
  this.supplierService.sendOffer(this.order.id,this.offer).subscribe({
    next: t => {
      this.response = t;
      console.log(this.response);
    }

  });
}

getOrders() {
    
  this.supplierService.getOrders().subscribe({
    next: t => {
      this.orders = t;
      console.log(this.orders);
    }

  });

}

seeItems(o:Order) {
  this.previewOrderItems = !this.previewOrderItems;
  this.supplierService.getItemsFromOrder(o.id).subscribe({
    next: t => {
      this.orderItems = t;
      console.log(this.orders);
    }

  });
}

writeOffer(o:Order){
  this.previewOffer=!this.previewOffer;
  
  this.order=o;
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
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SupplierRoutingModule } from './supplier-routing.module';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { AllOffersComponent } from './all-offers/all-offers.component';


@NgModule({
  declarations: [
    AllOrdersComponent,
    AllOffersComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    SupplierRoutingModule
    
    
  ]
})
export class SupplierModule { }
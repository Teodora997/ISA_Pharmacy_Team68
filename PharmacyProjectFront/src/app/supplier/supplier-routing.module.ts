import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllOffersComponent } from './all-offers/all-offers.component';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { SupplierHomepageComponent } from './supplier-homepage/supplier-homepage.component';



const routes: Routes = [
 
  { path: 'supplier-homepage', component: SupplierHomepageComponent },
  { path: 'all-orders', component: AllOrdersComponent },
  { path: 'all-offers', component: AllOffersComponent },
  
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SupplierRoutingModule { }
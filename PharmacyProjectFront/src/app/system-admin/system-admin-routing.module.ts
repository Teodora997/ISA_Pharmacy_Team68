import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDermatologistComponent } from './add-dermatologist/add-dermatologist.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { AddPharmacyAdminComponent } from './add-pharmacy-admin/add-pharmacy-admin.component';
import { AddPharmacyComponent } from './add-pharmacy/add-pharmacy.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { AddSystemAdminComponent } from './add-system-admin/add-system-admin.component';
import { AdminAllMedicinesComponent } from './all-medicines/admin-all-medicines.component';
import { LoyaltyProgramComponent } from './loyalty-program/loyalty-program.component';
import { SystemAdminHomepageComponent } from './system-admin-homepage/system-admin-homepage.component';


const routes: Routes = [
 
  { path: 'system-admin-homepage', component: SystemAdminHomepageComponent },
  { path: 'add-dermatologist', component: AddDermatologistComponent },
  { path: 'add-supplier', component: AddSupplierComponent },
  { path: 'add-pharmacy-admin', component: AddPharmacyAdminComponent},
  { path: 'add-system-admin', component: AddSystemAdminComponent},
  { path: 'add-pharmacy', component: AddPharmacyComponent},
  { path: 'add-medicine', component: AddMedicineComponent},
  { path: 'admin-all-medicines', component: AdminAllMedicinesComponent},
  { path: 'loyalty-program', component: LoyaltyProgramComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemAdminRoutingModule { }
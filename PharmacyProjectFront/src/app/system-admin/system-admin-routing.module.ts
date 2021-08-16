import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDermatologistComponent } from './add-dermatologist/add-dermatologist.component';
import { AddPharmacyAdminComponent } from './add-pharmacy-admin/add-pharmacy-admin.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { SystemAdminHomepageComponent } from './system-admin-homepage/system-admin-homepage.component';


const routes: Routes = [
 
  { path: 'system-admin-homepage', component: SystemAdminHomepageComponent },
  { path: 'add-dermatologist', component: AddDermatologistComponent },
  { path: 'add-supplier', component: AddSupplierComponent },
  { path: 'add-pharmacy-admin', component: AddPharmacyAdminComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemAdminRoutingModule { }
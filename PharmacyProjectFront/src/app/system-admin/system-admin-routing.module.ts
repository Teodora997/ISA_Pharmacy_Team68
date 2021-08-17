import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDermatologistComponent } from './add-dermatologist/add-dermatologist.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { AddPharmacyAdminComponent } from './add-pharmacy-admin/add-pharmacy-admin.component';
import { AddPharmacyComponent } from './add-pharmacy/add-pharmacy.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { SystemAdminHomepageComponent } from './system-admin-homepage/system-admin-homepage.component';


const routes: Routes = [
 
  { path: 'system-admin-homepage', component: SystemAdminHomepageComponent },
  { path: 'add-dermatologist', component: AddDermatologistComponent },
  { path: 'add-supplier', component: AddSupplierComponent },
  { path: 'add-pharmacy-admin', component: AddPharmacyAdminComponent},
  { path: 'add-pharmacy', component: AddPharmacyComponent},
  { path: 'add-medicine', component: AddMedicineComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SystemAdminRoutingModule { }
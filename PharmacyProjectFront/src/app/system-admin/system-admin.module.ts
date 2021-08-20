import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SystemAdminRoutingModule } from './system-admin-routing.module';
import { AddDermatologistComponent } from './add-dermatologist/add-dermatologist.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { AddPharmacyAdminComponent } from './add-pharmacy-admin/add-pharmacy-admin.component';
import { AddPharmacyComponent } from './add-pharmacy/add-pharmacy.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { AddSystemAdminComponent } from './add-system-admin/add-system-admin.component';
import { AdminAllMedicinesComponent } from './all-medicines/admin-all-medicines.component';


@NgModule({
  declarations: [
    AddDermatologistComponent,
    AddSupplierComponent,
    AddPharmacyAdminComponent,
    AddPharmacyComponent,
    AddMedicineComponent,
    AddSystemAdminComponent,
    AdminAllMedicinesComponent
  ],
  imports: [
    CommonModule,
    SystemAdminRoutingModule, 
    RouterModule,
    FormsModule,
    
  ]
})
export class SystemAdminModule { }
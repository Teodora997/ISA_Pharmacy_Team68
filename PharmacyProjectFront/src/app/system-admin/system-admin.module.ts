import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SystemAdminRoutingModule } from './system-admin-routing.module';
import { AddDermatologistComponent } from './add-dermatologist/add-dermatologist.component';
import { AddSupplierComponent } from './add-supplier/add-supplier.component';
import { AddPharmacyAdminComponent } from './add-pharmacy-admin/add-pharmacy-admin.component';


@NgModule({
  declarations: [
    AddDermatologistComponent,
    AddSupplierComponent,
    AddPharmacyAdminComponent
  ],
  imports: [
    CommonModule,
    SystemAdminRoutingModule, 
    RouterModule,
    FormsModule,
    
  ]
})
export class SystemAdminModule { }
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChangePasswordComponent } from '../change-password/change-password.component';
import { SupplierHomepageComponent } from '../supplier/supplier-homepage/supplier-homepage.component';
import { SupplierModule } from '../supplier/supplier.module';
import { SystemAdminHomepageComponent } from '../system-admin/system-admin-homepage/system-admin-homepage.component';
import { SystemAdminModule } from '../system-admin/system-admin.module';


const routes: Routes = [
 
  
  { path: 'change-password', component: ChangePasswordComponent },
  { path: 'system-admin-homepage', component: SystemAdminHomepageComponent },
  { path: 'supplier-homepage', component: SupplierHomepageComponent },
  
];

@NgModule({
  imports: [RouterModule.forChild(routes),
SystemAdminModule,
SupplierModule],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChangePasswordComponent } from '../change-password/change-password.component';
import { SystemAdminHomepageComponent } from '../system-admin/system-admin-homepage/system-admin-homepage.component';
import { SystemAdminModule } from '../system-admin/system-admin.module';


const routes: Routes = [
 
  
  { path: 'change-password', component: ChangePasswordComponent },
  { path: 'system-admin-homepage', component: SystemAdminHomepageComponent },
  
];

@NgModule({
  imports: [RouterModule.forChild(routes),
SystemAdminModule,],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
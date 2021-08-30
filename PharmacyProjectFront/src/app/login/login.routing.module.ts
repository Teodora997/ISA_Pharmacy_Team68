import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChangePasswordComponent } from '../change-password/change-password.component';
import { SystemAdminHomepageComponent } from '../system-admin/system-admin-homepage/system-admin-homepage.component';
import { SystemAdminModule } from '../system-admin/system-admin.module';
import { PhadminHomepageComponent } from '../pharmacy-admin/phadmin-homepage/phadmin-homepage.component';
import { PhadminModule } from '../pharmacy-admin/phadmin.module';


const routes: Routes = [
 
  
  { path: 'change-password', component: ChangePasswordComponent },
  { path: 'system-admin-homepage', component: SystemAdminHomepageComponent },
  { path: 'phadmin-homepage', component: PhadminHomepageComponent},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes),
SystemAdminModule, PhadminModule],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
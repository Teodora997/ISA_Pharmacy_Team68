import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';


import { ChangePasswordComponent } from '../change-password/change-password.component';
import { LoginRoutingModule } from './login.routing.module';
import { SystemAdminHomepageComponent } from '../system-admin/system-admin-homepage/system-admin-homepage.component';
import { SystemAdminModule } from '../system-admin/system-admin.module';
import { SystemAdminService } from '../service/system-admin.service';


@NgModule({
  declarations: [
   ChangePasswordComponent,
   SystemAdminHomepageComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    LoginRoutingModule,
    SystemAdminModule,
    
    
  ],
  providers: [
    SystemAdminService,
  ]
})
export class LoginModule { }
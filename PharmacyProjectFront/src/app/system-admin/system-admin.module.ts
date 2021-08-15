import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SystemAdminRoutingModule } from './system-admin-routing.module';


@NgModule({
  declarations: [
    
  ],
  imports: [
    CommonModule,
    SystemAdminRoutingModule, 
    RouterModule,
    FormsModule,
    
  ]
})
export class SystemAdminModule { }
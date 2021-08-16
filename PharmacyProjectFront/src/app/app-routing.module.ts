import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomePageComponent } from './homepage/homepage.component';
import {AllMedicinesComponent} from './homepage/all-medicines/all-medicines.component'
import {AllPharmaciesComponent} from './homepage/all-pharmacies/all-pharmacies.component'
import { SystemAdminModule } from './system-admin/system-admin.module';
import { PatientModule } from './patient/patient.module';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent} ,
  { path: 'homepage', component: HomePageComponent },
  { path: 'pharmacies', component: AllPharmaciesComponent },
  { path: 'medicines', component: AllMedicinesComponent },
  { path: '', redirectTo: 'homepage', pathMatch: 'full',}, 
  { path: '**', redirectTo: 'homepage', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  SystemAdminModule,
  PatientModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }



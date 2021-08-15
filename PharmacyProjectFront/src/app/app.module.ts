import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AllPharmaciesComponent } from './homepage/all-pharmacies/all-pharmacies.component';
import { AllMedicinesComponent } from './homepage/all-medicines/all-medicines.component';
import { LoginService } from './login/login.service';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ApiService, AuthService, ConfigService, UserService } from './service';
import { RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { HomePageComponent } from './homepage/homepage.component';
import { PharmacyService } from './service/pharmacy.service';
import {SystemAdminHomepageComponent} from './system-admin/system-admin-homepage/system-admin-homepage.component';
import { SystemAdminModule } from './system-admin/system-admin.module';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomePageComponent,
    AllMedicinesComponent,
    AllPharmaciesComponent,
    SystemAdminHomepageComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    SystemAdminModule
  ],
  providers: [
  LoginService,
  AuthService,
  UserService,
  PharmacyService,
  ApiService,
  ConfigService


],
  bootstrap: [AppComponent]
})
export class AppModule { }

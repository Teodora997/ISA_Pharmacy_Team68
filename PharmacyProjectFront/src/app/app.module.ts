import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WorkTimeService } from './work-time.service';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ApiService, AuthService, ConfigService, UserService } from './service';
import { RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { HomePageComponent } from './homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomePageComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
  ],
  providers: [WorkTimeService,
  LoginService,
  AuthService,
  UserService,
  ApiService,
  ConfigService


],
  bootstrap: [AppComponent]
})
export class AppModule { }

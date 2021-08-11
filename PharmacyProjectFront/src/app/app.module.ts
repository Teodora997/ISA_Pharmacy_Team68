import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { WorkTimeService } from './work-time.service';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/login.service';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ApiService, AuthService, ConfigService, UserService } from './service';
import { RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    routingComponent,
    RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
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

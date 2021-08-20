import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { PatientRoutingModule } from './patient-routing.module';
import { PatientPharmaciesComponent } from './patient-pharmacies/patient-pharmacies.component';
import { PatientPharmacyComponent } from './patient-pharmacy/patient-pharmacy.component';
import { MakeConsultingComponent } from './make-consulting/make-consulting.component';
import { PatientConsultingComponent } from './patient-consultings/patient-consultings.component';
import { PatientExaminationComponent } from './patient-examinations/patient-examinations.component';


@NgModule({
  declarations: [
    PatientPharmaciesComponent,
    PatientPharmacyComponent,
    MakeConsultingComponent,
    PatientConsultingComponent,
    PatientExaminationComponent
    
  ],
  imports: [
    CommonModule,
    PatientRoutingModule, 
    RouterModule,
    FormsModule,
    
  ]
})
export class PatientModule { }
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MakeConsultingComponent } from './make-consulting/make-consulting.component';
import { PatientConsultingComponent } from './patient-consultings/patient-consultings.component';
import { PatientHomepageComponent } from './patient-homepage/patient-homepage.component';
import { PatientPharmaciesComponent } from './patient-pharmacies/patient-pharmacies.component';
import { PatientPharmacyComponent } from './patient-pharmacy/patient-pharmacy.component';


const routes: Routes = [
 
  { path: 'patient-homepage', component: PatientHomepageComponent },
  { path: 'patient-pharmacies', component: PatientPharmaciesComponent },
  { path: 'patient-pharmacies/:id', component: PatientPharmacyComponent },
  { path: 'make-consulting', component: MakeConsultingComponent }, 
  { path: 'patient-consultings', component: PatientConsultingComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }
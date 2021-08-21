import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MakeConsultingComponent } from './make-consulting/make-consulting.component';
import { MedicineReservationComponent } from './medicine-reservation/medicine-reservation.component';
import { PatientComplaintComponent } from './patient-complaint/patient-complaint.component';
import { PatientConsultingComponent } from './patient-consultings/patient-consultings.component';
import { PatientExaminationComponent } from './patient-examinations/patient-examinations.component';
import { PatientHomepageComponent } from './patient-homepage/patient-homepage.component';
import { PatientPharmaciesComponent } from './patient-pharmacies/patient-pharmacies.component';
import { PatientPharmacyComponent } from './patient-pharmacy/patient-pharmacy.component';


const routes: Routes = [
 
  { path: 'patient-homepage', component: PatientHomepageComponent },
  { path: 'patient-pharmacies', component: PatientPharmaciesComponent },
  { path: 'patient-pharmacies/:id', component: PatientPharmacyComponent },
  { path: 'make-consulting', component: MakeConsultingComponent }, 
  { path: 'patient-consultings', component: PatientConsultingComponent },
  { path: 'patient-examinations', component: PatientExaminationComponent },
  { path: 'medicine-reservations', component: MedicineReservationComponent },
  { path: 'patient-complaint', component: PatientComplaintComponent }


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule { }
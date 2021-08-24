import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Consulting } from "../model/consulting";
import { DermatologistExaminations } from "../model/dermatologistExamination";
import { Medicine } from "../model/medicine";
import { Pharmacy } from "../model/pharmacy";
import { User } from "../user";
@Injectable()
export class PatientService {
  constructor(private http: HttpClient) {
  }
  public getMyAllergies(id:String): Observable<Medicine[]> {
    return this.http.get<Medicine[]>("http://localhost:8081/api/patients/getMyAllergies/"+id);
  }
  public addAllergy(userId:String,medId:string): Observable<String> {
    return this.http.post<String>("http://localhost:8081/api/patients/addAllergy/"+medId,userId);
  }
  public getAllMedicines(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>("http://localhost:8081/api/patients/getAllMedicines");
  }
  public getAvailableExaminations(pharmacyId:number): Observable<DermatologistExaminations[]> {
    return this.http.get<DermatologistExaminations[]>("http://localhost:8081/api/patients/getAvailableExaminations/"+pharmacyId);
  }
  public makeExamination(exId:number,patientId:string): Observable<number> {
    return this.http.post<number>("http://localhost:8081/api/patients/makeExamination/"+exId,patientId);
  }
  public getPharmaciesForConsulting(date:Date,time:String): Observable<Consulting[]> {
    return this.http.post<Consulting[]>("http://localhost:8081/api/patients/getPharmaciesForConsulting/"+date,time);
  }
  public makeConsulting(consId:number,patientId:string): Observable<number> {
    return this.http.post<number>("http://localhost:8081/api/patients/makeConsulting/"+consId,patientId);
  }
  public getConsultingsByPatient(patientId:string): Observable<Consulting[]> {
    return this.http.get<Consulting[]>("http://localhost:8081/api/patients/getConsultingsByPatient/"+patientId);
  }
  public cancelConsulting(consultingId:number) :Observable<Object>{
    return this.http.post<Object>("http://localhost:8081/api/patients/cancelConsulting",consultingId);
  }
  public getExaminationsByPatient(patientId:string): Observable<DermatologistExaminations[]> {
    return this.http.get<DermatologistExaminations[]>("http://localhost:8081/api/patients/getExaminationsByPatient/"+patientId);
  }
  public cancelExamination(examinationId:number) :Observable<Object>{
    return this.http.post<Object>("http://localhost:8081/api/patients/cancelExamination",examinationId);
  }

  public makeComplaint(patientId:string,userId:number,complaintText:string): Observable<number> {
    return this.http.post<number>("http://localhost:8081/api/patients/makeComplaint/"+ patientId +"/"+ userId,complaintText);
  }
  public getPharmaciesForComplaint(patientId:string): Observable<Pharmacy[]> {
    return this.http.get<Pharmacy[]>("http://localhost:8081/api/patients/getPharmaciesForComplaint/"+patientId);
  }
  public makeComplaintPharmacy(patientId:string,pharmacyId:number,complaintText:string): Observable<number> {
    return this.http.post<number>("http://localhost:8081/api/patients/makeComplaintPharmacy/"+ patientId +"/"+ pharmacyId,complaintText);
  }  
  public rateUser(userId:number,mark:string): Observable<number >{
    return this.http.post<number>("http://localhost:8081/api/patients/rateUser/"+ userId,mark);
  }
  public ratePharmacy(pharmacyId:number,mark:string): Observable<number >{
    return this.http.post<number>("http://localhost:8081/api/patients/ratePharmacy/"+ pharmacyId,mark);
  }
  public rateMedicine(medicineId:number,mark:string): Observable<number >{
    return this.http.post<number>("http://localhost:8081/api/patients/rateMedicine/"+ medicineId,mark);
  }
}
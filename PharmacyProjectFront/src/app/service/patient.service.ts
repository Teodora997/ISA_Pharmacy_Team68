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
}
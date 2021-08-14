import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pharmacy } from './list-of-pharmacies/pharmacy';

@Injectable({
  providedIn: 'root'
})
export class PharmacyService {
  private apiServerUrl='http://localhost:8081/api/pharmacies/all';

  constructor(private http : HttpClient) { }
  public getPharmacies():Observable<any>{
    return this.http.get<Pharmacy[]>(this.apiServerUrl);
  }
}

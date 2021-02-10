import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import {WorkTime} from './work-time';

@Injectable({
  providedIn: 'root'
})
export class WorkTimeService {
  private apiServerUrl='http://localhost:8081/api/worktime/all';


  constructor(private http : HttpClient) { }
  public getWorkTimes():Observable<any>{
    return this.http.get<WorkTime[]>(this.apiServerUrl);
  }
}

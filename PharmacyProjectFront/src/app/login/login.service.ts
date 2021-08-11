import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url='http://localhost:8081/auth/login';

  constructor(private http:HttpClient) { }

  login(login:Login){ 
    return this.http.post<any>(this.url,login);
  }
}

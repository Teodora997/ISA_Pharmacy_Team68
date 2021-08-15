import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { USER_ROLE_KEY } from '../config/localStorageKeys';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url='http://localhost:8081/auth/login';
  url1='http://localhost:8081/auth/logout';
  url2='http://localhost:8081/auth/getLoggedUser';

  constructor(private http:HttpClient) { }

  login(login:Login){ 
    return this.http.post<any>(this.url,login);
  }

  logout(request:Request){ 
    return this.http.post<any>(this.url1,request);
  }
  getLoggedUser() : Observable<any>{ 
    const userId=localStorage.getItem(USER_ROLE_KEY);
    return this.http.post<any>(this.url,userId);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { API_GET_USER } from './config/apiPaths';
import { USER_ID_KEY, USER_ROLE_KEY } from './config/localStorageKeys';
import { RequestForReg } from './registration/requestForReg';
import { ApiService } from './service/api.service';
import { ConfigService } from './service/config.service';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private user!:User; 
  currentUser: any;

  role:String= localStorage[USER_ROLE_KEY];

  
  _url1 = 'http://localhost:8081/api/users/public';
  _url2 = 'http://localhost:8081/api/users/register';

  constructor(private _http: HttpClient, private apiService: ApiService, private config: ConfigService) { }


  public register(newUser:User){
    return this._http.post<User>(this._url2,newUser);
 }
 public editProfile(editedUser:User) {
    return this._http.post("http://localhost:8081/api/users/editProfile",editedUser);
  }
  getUser(userId: number): Observable<any> {
      return this._http.get(`${this._url1}/${userId}`);
  }
  isUserLoggedIn(): boolean {
      return (localStorage.getItem(USER_ID_KEY) != null);
  }

  isUserPatient(): boolean {
      if(this.isUserLoggedIn()) {
          this.user = JSON.parse(sessionStorage["user"]);
          if(this.user.role==="ROLE_PATIENT"){
              return true;
          }
          return false
      }
      return false;
  }

  isUserDoctor(): boolean {
      if(this.isUserLoggedIn()) {
          this.user = JSON.parse(sessionStorage["user"]);
          if(this.user.role==="ROLE_DERMATOLOGIST"){
              return true;
          }
          return false
      }

      return false;
  }

  isUserPharmacist(): boolean {
      if(this.isUserLoggedIn()) {
          this.user = JSON.parse(sessionStorage["user"]);
          if(this.user.role==="ROLE_PHARMACIST"){
              return true;
          }
          return false
      }

      return false;
  }

  isUserSysAdmin(): boolean {
      if(this.isUserLoggedIn()) {
          this.user = JSON.parse(sessionStorage["user"]);
          if(this.user.role==="ROLE_SYS_ADMIN"){
              return true;
          }
          return false
      }

      return false;
  }

  isUserPhAdmin(): boolean {
      if(this.isUserLoggedIn()) {
          this.user = JSON.parse(sessionStorage["user"]);
          if(this.user.role==="ROLE_PH_ADMIN"){
              return true;
          }
          return false
      }

      return false;
  }

  public getUserInfo(): Observable<any> {
      const userId = localStorage.getItem(USER_ID_KEY);
      return this._http.get(`${API_GET_USER}/${userId}`);
  }

  initUser() {
      const promise = this.apiService.get(this.config.refresh_token_url).toPromise()
        .then(res => {
          if (res.access_token !== null) {
            return this.getMyInfo().toPromise()
              .then(user => {
                this.currentUser = user;
              });
          }else{return null;}
        })
        .catch(() => null);
      return promise;
  }

  setupUser(user:User) {
      this.currentUser = user;
  }

  getMyInfo() {
      return this.apiService.get(this.config.whoami_url)
        .pipe(map(user => {
          this.currentUser = user;
          return user;
        }));
    }

    
}

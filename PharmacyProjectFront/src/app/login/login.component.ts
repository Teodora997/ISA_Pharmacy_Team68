import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { USERNAME_KEY, USER_ID_KEY, USER_ROLE_KEY, USER_TOKEN_KEY } from '../config/localStorageKeys';
import { AuthService } from '../service/auth.service';
import { User } from '../user';
import { UserService } from '../user.service';
import { Login } from './login';
import { LoginService } from './login.service';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'Login';

  form!: FormGroup;
  loginModel=new Login('','');
  loginForm!:FormGroup;
  u!:User ;

  /**
   * Boolean used in telling the UI
   * that the form has been submitted
   * and is awaiting a response
   */
  submitted = false;

  /**
   * Notification message from received
   * form request or router
   */

  returnUrl: string | undefined;
  private ngUnsubscribe: Subject<void> = new Subject<void>();

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private _loginService: LoginService

  ) {

  }

  ngOnInit() {
    this.route.params
      .pipe(takeUntil(this.ngUnsubscribe));
    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.form = this.formBuilder.group({
      email: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
    });
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  get f(){
    return this.loginForm.controls;
  }
  onClickLogin(){
    this.submitted = true;
    this._loginService.login(this.loginModel)
   .subscribe(
    data => {
        this.u = data as User;
        sessionStorage.setItem("user",JSON.stringify(this.u));
        data = data as User;        
        console.log(data);
        
        localStorage.setItem(USER_ID_KEY, data.id);
        localStorage.setItem(USER_ROLE_KEY, data.authorities[0]);
        localStorage.setItem(USERNAME_KEY, data.email);
        localStorage.setItem(USER_TOKEN_KEY, data.token.accessToken);
        localStorage.setItem(USER_ROLE_KEY, data.role);
        
        alert("Logged in!");    
    },
    error=> { 
        alert("Wrong password or username")
        this.submitted = false;
    });
    this.submitted = true;
}

}

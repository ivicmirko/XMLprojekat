import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginParams } from '../model/login-params';
import { ProfileDTO } from '../model/profile-dto';
import { HttpClient } from '@angular/common/http';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { Router } from '@angular/router';
import { AuthService } from '../service/Auth/auth.service';
import { RouterService } from '../service/Router/router.service';
import { Location } from '@angular/common';
import { ShareService } from '../service/Share/share.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm : FormGroup;
  submitted = false;
  success = false;
  isLogged=false;
  errorMessage='';
  private loginParams: LoginParams;
  private profile: ProfileDTO;

  constructor(private formBuilder: FormBuilder, private httpClient: HttpClient, private sessionStorageService: SessionStorageService,
    private router: Router,private authService: AuthService, private routerService: RouterService,
    private location: Location, private shareService:ShareService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  login(){
    this.submitted=true;

    if(this.loginForm.invalid){
      return;
    }

    this.success=true;


    this.loginParams= new LoginParams(
      this.loginForm.get('username').value,
      this.loginForm.get('password').value
    );

    console.log(this.loginParams);
    this.authService.signIn(this.loginParams).subscribe(
      data=>
      {
        this.profile=data;
        this.sessionStorageService.saveToken(data.token);
        this.sessionStorageService.saveUsername(data.username);
        this.sessionStorageService.saveUserData(this.profile);

        this.isLogged=true;
        this.shareService.sendProfile(this.profile);
        this.shareService.sendIsLogged(this.isLogged);
        console.log(this.profile);
        if(this.routerService.getPreviousUrl().includes('register')){
          this.router.navigate(['']);
        }else if(this.routerService.getPreviousUrl().includes('admin')){
          this.router.navigate(['']);
        }else{
          this.location.back();
        }
      },
      error=>{
        this.errorMessage="Wrong password, please try again.";
        alert("Pogresan password ili korisnicko ime!");
        this.success=false;
      })

  }
}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import {Location} from '@angular/common'


import { Router } from '@angular/router';
import { ProfileDTO } from '../model/profile-dto';
import { ShareService } from '../service/Share/share.service';
import { AuthService } from '../service/Auth/auth.service';
import { HttpClient } from '@angular/common/http';
import { RouterService } from '../service/Router/router.service';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { LoginParams } from '../model/login-params';
import { Profile } from 'selenium-webdriver/firefox';
import { SyncService } from '../service/Sync/sync.service';

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
    private router: Router, private routerService: RouterService,private authService:AuthService,
    private location: Location, private shareService:ShareService,private syncService:SyncService) { }
  
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
        let role=this.profile.authorities[0];
      if(role != 'agent'){
        console.log('nije agent');
        this.logOut();
        return;
      }

        this.profile=data;
        this.sessionStorageService.saveToken(data.token);
        this.sessionStorageService.saveUsername(data.username);
        this.sessionStorageService.saveUserData(this.profile);

        this.isLogged=true;
        this.shareService.sendProfile(this.profile);
        this.shareService.sendIsLogged(this.isLogged);
        this.syncData();
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

  logOut(){
    this.authService.logOut().subscribe(data=>
      {
  
      },
      error=>{
        alert('greska');
      })
    this.sessionStorageService.signOut();
    this.router.navigate(['login']);
  }

  syncData(){
    let username=this.sessionStorageService.getUserName();
    this.syncService.syncBase(username).subscribe(data=>{
      alert('baza uspesno azurirana');
    },
    error=>{
      console.log('buc');
    })
  }

}

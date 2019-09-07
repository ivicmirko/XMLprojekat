import { Injectable } from '@angular/core';
import { ProfileDTO } from 'src/app/model/profile-dto';

const TOKEN_KEY = 'AuthToken';
const USERNAME_KEY = 'AuthUsername';
const AUTHORITIES_KEY = 'AuthAuthorities';
const USER_ID='AuthoritiesID';
const USER_DATA='UserData';

@Injectable({
  providedIn: 'root'
})
export class SessionStorageService {

  constructor() { }

  signOut(){
    window.sessionStorage.clear();
  }

  public saveToken(token: string){
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY,token);
  }

  public saveUsername(username:string){
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY,username);
  }

  public saveId(id:Number){
    window.sessionStorage.removeItem(USER_ID);
    window.sessionStorage.setItem(USER_ID,id.toString());
  }

  public getToken():string{
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public getUserName():string{
    return sessionStorage.getItem(USERNAME_KEY);
  }

  public getUserId():Number{
    return Number(sessionStorage.getItem(USER_ID)); 
    
  }

  public saveUserData(profile:ProfileDTO){
    window.sessionStorage.removeItem(USER_DATA);
    let profileJson=JSON.stringify(profile);
    window.sessionStorage.setItem(USER_DATA,profileJson);
  }

  public getUserData():ProfileDTO{
    let profile=sessionStorage.getItem(USER_DATA);
    return JSON.parse(profile);
  }


}

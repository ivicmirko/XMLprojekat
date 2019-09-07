import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { LoginParams } from 'src/app/model/login-params';
import { Observable } from 'rxjs';
import { ProfileDTO } from 'src/app/model/profile-dto';
import { RegisterParams } from 'src/app/model/register-params';
import { UserDTO } from 'src/app/model/user-dto';
import { AgentDTO } from 'src/app/model/agent-dto';
import { AgentAdd } from 'src/app/model/agent-add';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const authUrl = "http://localhost:8763/auth/api/auth/"

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl= authUrl + 'login';
  private registerUrl= authUrl + 'signup';
  private getLoggedUrl= authUrl + 'getLogged';
  private logoutUrl= authUrl + 'logout';
  private getAllUsersUrl=authUrl+ 'getAllUsers';
  private getAllAgentsUrl=authUrl+ 'getAllAgents';
  private blockUserUrl=authUrl+'blockUser/';
  private unblockUserUrl=authUrl+ 'unblockUser/';
  private addAgentUrl=authUrl+ 'addagent';
  private deleteUserUrl=authUrl+'deleteUser/'

  constructor(private http: HttpClient) { }

  signIn(loginParams : LoginParams): Observable<ProfileDTO>{
    return this.http.post<ProfileDTO>(this.loginUrl,loginParams,httpOptions);
  }

  signUp(registerParams: RegisterParams):Observable<any>{
    return this.http.post<string>(this.registerUrl,registerParams,httpOptions);
  }

  getLogged():Observable<ProfileDTO>{
    return this.http.get<ProfileDTO>(this.getLoggedUrl,httpOptions);
  }

  logOut():Observable<any>{
    return this.http.get<any>(this.logoutUrl,httpOptions);
  }

  getAllUsers():Observable<UserDTO[]>{
    return this.http.get<UserDTO[]>(this.getAllUsersUrl,httpOptions);
  }

  getAllAgents():Observable<AgentDTO[]>{
    return this.http.get<AgentDTO[]>(this.getAllAgentsUrl,httpOptions);
  }

  blockUser(username:String):Observable<any>{
    let url=this.blockUserUrl+username;
    return this.http.put(url,null,httpOptions);
  }

  unblockUser(username:String):Observable<any>{
    let url=this.unblockUserUrl+username;
    return this.http.put(url,null,httpOptions);
  }

  deleteUser(username:String):Observable<any>{
    let url=this.deleteUserUrl+username;
    return this.http.put<any>(url,null,httpOptions);
  }

  addAgent(agent:AgentAdd):Observable<any>{
    return this.http.post<any>(this.addAgentUrl,agent,httpOptions)
  }



}

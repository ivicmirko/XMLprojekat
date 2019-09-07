import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const agentUrl = "http://localhost:2225/api/agent/res/"

@Injectable({
  providedIn: 'root'
})
export class SyncService {

  private syncBaseUrl=agentUrl+"syncData/";

  constructor(private http:HttpClient) { }

  syncBase(agentUsername:String){
    let url=this.syncBaseUrl+agentUsername;
    return this.http.get(url,httpOptions);
  }
}

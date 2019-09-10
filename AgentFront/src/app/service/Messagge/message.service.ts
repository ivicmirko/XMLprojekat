import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from 'src/app/model/message';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const agentUrl="http://localhost:2225/api/agent/message/"

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private sendMessageUrl=agentUrl+"sendMessage";
  private getInboxUrl=agentUrl+"getInbox/";
  private getSentUrl=agentUrl+"getSent/";

  constructor(private http:HttpClient) { }

  sendMessage(message:Message):Observable<any>{
    return this.http.post<any>(this.sendMessageUrl,message,httpOptions);
  }

  getInbox(id:Number):Observable<Message[]>{
    let url=this.getInboxUrl+id;
    return this.http.get<Message[]>(url,httpOptions);
  }

  getSent(id:Number):Observable<Message[]>{
    console.log(id);
    let url=this.getSentUrl+id;
    return this.http.get<Message[]>(url,httpOptions);
  }

  
}

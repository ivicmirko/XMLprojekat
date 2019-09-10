import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClientModule, HttpClient } from '@angular/common/http';
import { MessageDTO } from 'src/app/model/message-dto';
import { Observable } from 'rxjs';
import { Message } from 'src/app/model/message';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const srcResUrl="http://localhost:8763/srcres/api/message/"

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private sendMessageUrl=srcResUrl+"sendMessage";
  private sendRespondUrl=srcResUrl+"respondMessage";
  private getInboxUrl=srcResUrl+"getInbox/";
  private getSentUrl=srcResUrl+"getSent/";

  constructor(private http:HttpClient) { }

  sendMessage(message:MessageDTO):Observable<any>{
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

  sendRespond(message:Message):Observable<any>{
    return this.http.post<any>(this.sendRespondUrl,message,httpOptions);
  }
}

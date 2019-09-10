import { Component, OnInit } from '@angular/core';
import { Message } from '../model/message';
import { MessageService } from '../service/Messagge/message.service';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.scss']
})
export class MessageComponent implements OnInit {

  newMessageForm:FormGroup;
  idReceiver:Number;

  addMod=false;
  inbox=true;
  sent=false;

  inboxMessages:Message[]=[];
  sentMessages:Message[]=[];
  newMessage=new Message;
  showingMessages:Message[]=[];
  
  constructor(private sessionStorageService:SessionStorageService,private messageServcie:MessageService,private formBuilder:FormBuilder,
    private messageService:MessageService) { }

  ngOnInit() {
    this.newMessageForm=this.formBuilder.group({
      text:['',Validators.required]
    });

    let myId=this.sessionStorageService.getUserData().id;
    this.messageServcie.getInbox(myId).subscribe(data=>{
      this.inboxMessages=data;
      this.showingMessages=data;
    },error=>{
      console.log('neuspesno inbox');
    });

    this.messageServcie.getSent(myId).subscribe(data=>{
      console.log(data);
      this.sentMessages=data;
    },error=>{
      console.log('neuspesno sent');
    })
  }

  getSent(){
    this.sent=true;
    this.inbox=false;
    this.showingMessages=this.sentMessages;
  }

  getInbox(){
    this.sent=false;
    this.inbox=true;
    this.showingMessages=this.inboxMessages;
  }

  respondMessageClick(id:Number){
    this.idReceiver=id;
    this.addMod=true;
  }

  respondMessage(){

    if(this.newMessageForm.invalid){
      return;
    }
    
    let idSender=this.sessionStorageService.getUserData().id;
    this.newMessage.idSender=idSender;
    this.newMessage.text=this.newMessageForm.get('text').value;
    this.newMessage.idReceiver=this.idReceiver;
    this.newMessage.date=new Date();
    
    this.messageService.sendMessage(this.newMessage).subscribe(data=>{
      alert('poslato');
      this.addMod=false;
      window.location.reload();;
    },error=>{
      console.log('greska');
    });
  }
}



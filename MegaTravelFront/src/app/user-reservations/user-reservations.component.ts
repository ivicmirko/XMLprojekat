import { Component, OnInit } from '@angular/core';
import { Reservation } from '../model/reservation';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';
import { AuthService } from '../service/Auth/auth.service';
import { ProfileDTO } from '../model/profile-dto';
import { ShareService } from '../service/Share/share.service';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { MessageDTO } from '../model/message-dto';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MessageService } from '../service/Message/message.service';
import { runInThisContext } from 'vm';
import { RatingService } from '../service/Rating/rating.service';
import { AddCommentDTO } from '../model/add-comment-dto';
import { RatingDTO } from '../model/rating-dto';

@Component({
  selector: 'app-user-reservations',
  templateUrl: './user-reservations.component.html',
  styleUrls: ['./user-reservations.component.scss']
})
export class UserReservationsComponent implements OnInit {

  reservations:Reservation[];
  addMod=false;
  comment=false;
  rating=false;
  profile:ProfileDTO;
  resId:Number;
  commentResId:Number;
  rateResId:Number;

  messageForm:FormGroup;
  commentForm:FormGroup;
  rateForm:FormGroup;

  constructor(private srcResService:SearchReservationService,private authService:AuthService,
    private shareService:ShareService,private sessionStorageService:SessionStorageService,private formBuilder:FormBuilder,
    private messageService:MessageService, private ratingService:RatingService) { }

  ngOnInit() {

    this.messageForm=this.formBuilder.group({
      text:['',Validators.required]
    });

    
    this.commentForm=this.formBuilder.group({
      text:['',Validators.required]
    });

    this.rateForm=this.formBuilder.group({
      rate:Number
    });

    this.getMyReservations();


  }

  getMyReservations(){
    let username=this.sessionStorageService.getUserName();
    this.srcResService.getMyReservations(username).subscribe(data=>{
      this.reservations=data;
      console.log(data);
    },
    error=>{
      console.log('neuspesan getMyReservation');
    });
  }

  cancelReservation(id:Number){
    this.srcResService.cancelReservation(id).subscribe(data=>{
      console.log('uspesno otkazano');
      this.getMyReservations();
    })
  }

  getLogged(){
    console.log('loog');
    this.authService.getLogged().subscribe(data=>{
      console.log('usa');
      this.profile=data;
      //this.anyLogged=true;
      this.shareService.sendIsLogged(true);
      this.shareService.sendProfile(this.profile);
      //let role=this.profile.authorities[0];
      // if(role == 'admin'){
      //   this.adminLogged=true;
      // }else{
      //   this.adminLogged=false;
      // }
    },
    error=>{
      this.profile=null;
      // this.anyLogged=false;
      // this.adminLogged=false;
    });
  }

  sendMessageClick(id:Number){
    this.addMod=true;
    this.resId=id;
  }

  sendMessage(){

    if(this.messageForm.invalid){
      return;
    }
    let message=new MessageDTO;
    let idSender=this.sessionStorageService.getUserData().id;
    message.reservationId=this.resId;
    message.text=this.messageForm.get('text').value;
    message.idSender=idSender;

    this.messageService.sendMessage(message).subscribe(data=>{
      alert('poslato');
      this.addMod=false;
    },error=>{
      console.log('greska');
    })
  }
  sendRatingClick(id:Number){
    this.addMod=false;
    this.rating=true;
    this.comment=false;
    this.rateResId=id;
  }

  sendRating(){
    let ocena=this.rateForm.get('rate').value;
    if(ocena<1 || ocena>5){
      return;
    }

    let rateDTO=new RatingDTO;
    rateDTO.rate=ocena;
    rateDTO.reservationId=this.rateResId;
    console.log(rateDTO);
    this.ratingService.sendRating(rateDTO).subscribe(data=>{
      this.rating=false;
      alert('poslato');
    },error=>{
      console.log('Neuspesno poslat komentar');
    })

  }

  sendCommentClick(id:Number){
    this.addMod=false;
    this.rating=false;
    this.comment=true;
    this.commentResId=id;
  }

  sendComment(){
    if(this.commentForm.invalid){
      return;
    }
    let commentDTO=new AddCommentDTO;
    let userId=this.sessionStorageService.getUserData().id;
    commentDTO.idUser=userId;
    commentDTO.date=new Date();
    commentDTO.text=this.commentForm.get('text').value;
    commentDTO.reservationId=this.commentResId;
    console.log(commentDTO);
    this.ratingService.sendComment(commentDTO).subscribe(data=>{
      this.comment=false;
      alert('poslato');
    },error=>{
      console.log('Neuspesno poslat komentar');
    })

  }

}

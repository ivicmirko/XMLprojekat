import { Component, OnInit } from '@angular/core';
import { Reservation } from '../model/reservation';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';
import { AuthService } from '../service/Auth/auth.service';
import { ProfileDTO } from '../model/profile-dto';
import { ShareService } from '../service/Share/share.service';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';

@Component({
  selector: 'app-user-reservations',
  templateUrl: './user-reservations.component.html',
  styleUrls: ['./user-reservations.component.scss']
})
export class UserReservationsComponent implements OnInit {

  reservations:Reservation[];
  adMmod=false;
  profile:ProfileDTO;

  constructor(private srcResService:SearchReservationService,private authService:AuthService,
    private shareService:ShareService,private sessionStorageService:SessionStorageService) { }

  ngOnInit() {

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

}

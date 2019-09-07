import { Component, OnInit } from '@angular/core';
import { AccommodationFacility } from '../model/accommodation-facility';
import { Reservation } from '../model/reservation';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';


@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.scss']
})
export class FacilitiesComponent implements OnInit {


  facilities:AccommodationFacility[];
  reservations:Reservation[]=[];

  constructor(private sessionStorageService:SessionStorageService,private resService:SearchReservationService) { }

  ngOnInit() {

    let username;
    username=this.sessionStorageService.getUserName();
    if(username==null){
      return;
    }

    // this.resService.getAllReservations(username).subscribe(data=>
    //   {
    //     this.reservations=data;
    //     console.table(data);
    //   },
    //   error=>
    //   {
    //     console.log('nece reze');
    //   });
  }

}

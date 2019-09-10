import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../service/Accommodation/accommodation.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Reservation } from '../model/reservation';
import { AccommodationUnit } from '../model/accommodation-unit';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { AccommodationUnitDTO } from '../model/accommodation-unit-dto';
import { NewReservationDTO } from '../model/new-reservation-dto';
import { SyncService } from '../service/Sync/sync.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.scss']
})
export class ReservationsComponent implements OnInit {

  addMod=false;
  isRealizedNewReservation=false;
  newReservation=new NewReservationDTO;

  reservations:Reservation[];
  newResForm:FormGroup;
  unitId:Number=1;
  units:AccommodationUnitDTO[];

  constructor(private accommodationService:AccommodationService,private formBuilder:FormBuilder,
    private sessionStorageService:SessionStorageService,private syncService:SyncService) { }

  ngOnInit() {
    this.newResForm=this.formBuilder.group({
      checkInDate:Date,
      checkOutDate:Date,
      totalPrice:Number,
      isRealized:Boolean
    });

    let agentId=this.sessionStorageService.getUserId();
    this.accommodationService.getAllReservations(agentId).subscribe(data=>{
      this.reservations=data;
      console.log(data);
    },error=>{
      console.log('nesuspesno rezervacije');
    });

    this.accommodationService.getAllUnits(agentId).subscribe(data=>{
      this.units=data;
      console.log(data);
      console.log('ima unita'+this.units.length);
    },error=>{
      console.log('nesupseno unite');
    });
  }

  makeResClick(){
    this.addMod=true;
  }

  makeReservation(){

    // console.log(this.newResForm.get('').value);
    this.newReservation.checkInDate=this.newResForm.get('checkInDate').value;
    this.newReservation.checkOutDate=this.newResForm.get('checkOutDate').value;
    this.newReservation.isRealised=this.isRealizedNewReservation;
    this.newReservation.totalPrice=this.newResForm.get('totalPrice').value;
    this.newReservation.unitId=this.unitId;

    this.accommodationService.makeReservation(this.newReservation).subscribe(data=>{
      let username=this.sessionStorageService.getUserName();
      this.syncService.syncBase(username).subscribe(data=>{
        console.log('baza uspesno azurirana');
        window.location.reload();
        this.addMod=false;
      },
      error=>{
        console.log('buc');
        
      })
    },error=>{
      console.log('neuspesno make reservation');
    })

    console.log(this.newReservation);
  }

  realizeReservation(id:Number){
    this.accommodationService.realizeReservation(id).subscribe(data=>{
      let username=this.sessionStorageService.getUserName();
      this.syncService.syncBase(username).subscribe(data=>{
        console.log('baza uspesno azurirana');
        window.location.reload();
        this.addMod=false;
      },
      error=>{
        console.log('buc');
        
      });
    },error=>{
      console.log('neuspesno realizacija rezervacije');
    });
  }


}

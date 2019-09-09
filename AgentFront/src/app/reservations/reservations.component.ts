import { Component, OnInit } from '@angular/core';
import { AccommodationService } from '../service/Accommodation/accommodation.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Reservation } from '../model/reservation';
import { AccommodationUnit } from '../model/accommodation-unit';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { AccommodationUnitDTO } from '../model/accommodation-unit-dto';
import { NewReservationDTO } from '../model/new-reservation-dto';

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
    private sessionStorageService:SessionStorageService) { }

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
    this.newReservation.accommodationUnitId=this.unitId;

    console.log(this.newReservation);
  }

}

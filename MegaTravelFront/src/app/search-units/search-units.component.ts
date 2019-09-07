import { Component, OnInit } from '@angular/core';
import { AccommodationUnit } from '../model/accommodation-unit';
import { UnitAS } from '../model/unit-as';
import { SearchFormParams } from '../model/search-form-params';
import { AccommodationFacility } from '../model/accommodation-facility';
import { FormGroup, FormBuilder } from '@angular/forms';
import { SifarnikService } from '../service/Sifarnik/sifarnik.service';
import { Router } from '@angular/router';
import { ProfileDTO } from '../model/profile-dto';
import { ShareService } from '../service/Share/share.service';
import { AuthService } from '../service/Auth/auth.service';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';
import { ReservationDTO } from '../model/reservation-dto';
import { SessionState } from 'http2';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';

@Component({
  selector: 'app-search-units',
  templateUrl: './search-units.component.html',
  styleUrls: ['./search-units.component.scss']
})
export class SearchUnitsComponent implements OnInit {

  searchForm:FormGroup;
  destination:String;
  accommodationFacility:AccommodationFacility;
  searchParams:SearchFormParams;
  // resTransferParams:ResTransferParams;
  unitAS:UnitAS[];
  units:AccommodationUnit[];
  id:Number;
  cancelDate:Date;
  theCheckBox:boolean;
  uasFilters=new Map<String,Number>();
  filtratedUnits:AccommodationUnit[]=[];
  showingUnits:AccommodationUnit[]=[];
  profile:ProfileDTO;
  // reviews:Review[];


  constructor(private formBuilder:FormBuilder,private sifarnikService:SifarnikService,private router:Router,
    private authService: AuthService, private shareService:ShareService,private srcResService:SearchReservationService,
    private sessionStorageService:SessionStorageService) { }

  ngOnInit() {
    this.getLogged();

    this.searchForm=this.formBuilder.group({
      destination:[''],
      startDate:Date,
      endDate:Date,
      persons:Number
    });

    this.sifarnikService.getAlluas().subscribe(data=>{
      this.unitAS=data;
    });

    let retrievedObject=localStorage.getItem('params');
    this.searchParams=JSON.parse(retrievedObject);
    this.searchForm.controls['destination'].setValue(this.searchParams.destinationName);
    this.searchForm.controls['startDate'].setValue(this.searchParams.checkIn);
    this.searchForm.controls['endDate'].setValue(this.searchParams.checkOut);
    this.searchForm.controls['persons'].setValue(this.searchParams.numPersons);

    let tem=localStorage.getItem('idfac');
    this.id=JSON.parse(tem);

    this.srcResService.getFacility(this.id).subscribe(data=>{
      this.accommodationFacility=data;
    },
    error=>{
      console.log('Ne kupi facility by id');
    });

    this.srcResService.getFreeUnits(this.searchParams,this.id).subscribe(data=>{
      this.units=data;
      this.showingUnits=data;
    },
    error=>{
      console.log('ne da free unitse');
    });
    

    //kraj init a
  }

  typeFilterChanged(e,id:string){
    console.log(this.units);
    if(e.target.checked){
      this.uasFilters.set(id,1);

    }else{
      this.uasFilters.delete(id);
    }
    
    console.log(id+"aaa");
    console.log(this.uasFilters);
    this.showingUnits=this.units;
    this.filtratedUnits=[];
    for(let i=0; i<this.units.length;i++){
      for(let key of Array.from( this.uasFilters.keys())){
        
        for(let k=0 ; k< this.units[i].unitAS.length; k++){
          if(this.units[i].unitAS[k].name === key){
            console.log("muuu");
            if(!this.filtratedUnits.includes(this.units[i])){
              this.filtratedUnits.push(this.units[i]);
            }
          }
        }
      }
    }    
    this.showingUnits=this.filtratedUnits;
    if(this.uasFilters.size==0){
      this.showingUnits=this.units;
    }
    
  }

  searchAgain(){
    if((this.searchForm.get('startDate').value > this.searchForm.get('endDate').value)){
    alert("Datum napustanja smestaja mora biti posle datuma checkIn-a!");
    return;
  }

  this.searchParams= new SearchFormParams(this.searchForm.get('destination').value,this.searchForm.get('startDate').value,
  this.searchForm.get('endDate').value,
  this.searchForm.get('persons').value);
  localStorage.setItem('params',JSON.stringify(this.searchParams));
  
  this.router.navigate(['/search']);
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

reserve(unit:AccommodationUnit){

  let retrievedObject=localStorage.getItem('params');
  this.searchParams=JSON.parse(retrievedObject);
  let username=this.sessionStorageService.getUserName();
  console.log(username);
  let totalPrice=Number(unit.currentPrice)*Number(unit.numberOfDays);

  let reservationDTO=new ReservationDTO(this.searchParams.checkIn,this.searchParams.checkOut,unit.id,username,totalPrice);
  this.srcResService.makeReservation(reservationDTO).subscribe(data=>
    {
      alert("Rezervacija uspesno izvrsena!");
      this.searchParams= new SearchFormParams(this.searchForm.get('destination').value,this.searchForm.get('startDate').value,
      this.searchForm.get('endDate').value,this.searchForm.get('persons').value);
      
      localStorage.setItem('params',JSON.stringify(this.searchParams));
      this.searchAgain();
    },
    error=>
    {
      console.log("Neuspesna rezervacija");
    });
}

}

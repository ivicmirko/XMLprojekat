import { Component, OnInit } from '@angular/core';
import { AccommodationFacility } from '../model/accommodation-facility';
import { Reservation } from '../model/reservation';
import { SessionStorageService } from '../service/SessionStorage/session-storage.service';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Category } from '../model/category';
import { FacilityType } from '../model/facility-type';
import { FacilityAS } from '../model/facility-as';
import { Destination } from '../model/destination';
import { SifarnikService } from '../service/Sifarnik/sifarnik.service';
import { AccommodationService } from '../service/Accommodation/accommodation.service';
import { NewFacilityDTO } from '../model/new-facility-dto';
import { DomSanitizer } from '@angular/platform-browser';
import { runInThisContext } from 'vm';
import { UnitAS } from '../model/unit-as';
import { NewUnitDto } from '../model/new-unit-dto';



@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.scss']
})
export class FacilitiesComponent implements OnInit {

  newFacilityId:Number;
  newFacility=new NewFacilityDTO;
  newFacilityForm:FormGroup;
  
  newUnitForm:FormGroup;
  unitFacilityId:Number;
  newUnit=new NewUnitDto;

  facilities:AccommodationFacility[];
  destinations:Destination[];
  categories:Category[];
  facilityTypes:FacilityType[];
  facilityAS:FacilityAS[];
  unitAS:UnitAS[];

  addFMod=false;
  addUMod=false;
  submitted=false;
  
  canBeCanceled=false;
  destinationId=1;
  facilityTypeId=1;
  categoryId=1;
  fasId=[];
  uasId=[];
  
  image:File=null;
  imagesUrl:string[]=[];
  images:any[]=[];

  constructor(private sessionStorageService:SessionStorageService,private resService:SearchReservationService,
    private formBuilder:FormBuilder,private sifarnikService:SifarnikService,private accommodationService:AccommodationService,
    private sanitizer:DomSanitizer) { }

  ngOnInit() {

    let username;
    username=this.sessionStorageService.getUserName();
    if(username==null){
      return;
    }

    this.newFacilityForm=this.formBuilder.group({
      name:['',Validators.required],
      description: ['', Validators.required],
      address:['',Validators.required],
      latitude: Number,
      longitude: Number,
      descriptionLocation: ['', Validators.required],
    });

    this.newUnitForm=this.formBuilder.group({
      capacity:Number,
      canBeCanceled:Boolean,
      daysBefore:Number,
      january:Number,
      february:Number,
      march:Number,
      april:Number,
      may:Number,
      june:Number,
      july:Number,
      august:Number,
      september:Number,
      october:Number,
      november:Number,
      december:Number

    });

    this.sifarnikService.getAllDestinations().subscribe(data=>{
      this.destinations=data;
    },
    error=>{
      console.log('neusposno destinacije');
    });

    this.sifarnikService.getAllFacilityTypes().subscribe(data=>{
      this.facilityTypes=data;
    },
    error=>{
      console.log('neusposno tipovi');
    });

    this.sifarnikService.getAllCategories().subscribe(data=>{
      this.categories=data;
    },
    error=>{
      console.log('neusposno kategorije');
    });

    this.sifarnikService.getAllfas().subscribe(data=>{
      this.facilityAS=data;
    },
    error=>{
      console.log('neusposno fas');
    });

    this.sifarnikService.getAlluas().subscribe(data=>{
      this.unitAS=data;
    },
    error=>{
      console.log('neusposno fas');
    });

    this.accommodationService.getAllFacilities(2).subscribe(data=>{
      this.facilities=data;
      this.imagesUrl=[];
      
      console.log(this.facilities);
      for(let ij=0; ij< this.facilities.length;ij++){
          let objectURL = 'data:image/jpeg;base64,' + this.facilities[ij].image;
          this.images.push(this.sanitizer.bypassSecurityTrustUrl(objectURL));
        console.log(this.images);
      }
    },
    error=>{
      console.log('prc');
    });

  }

  imageSelected(event){
    this.image=<File>event.target.files[0];
    console.log(event);
  }

  uploadImage(){
    this.accommodationService.uploadImage(this.image,this.newFacilityId).subscribe(data=>{
      console.log('uspenso slika');
      this.submitted=false;
      let agentId=this.sessionStorageService.getUserData().id;
      this.accommodationService.getAllFacilities(agentId).subscribe(data=>{
        this.facilities=data;
      });
    },
    error=>{
      console.log('neuspesno slika');
    })
  }

  addFacilityClick(){
    this.addFMod=true;
  }

  addFacility(){
    console.log(this.newFacility);

    if(this.newFacilityForm.invalid){
      alert("Popunite polja sa zvezdicom");
      return;
    }
    console.log('hoppaa'+this.newFacilityForm.get('name').value);
    this.newFacility.name=this.newFacilityForm.get('name').value;
    console.log('hoppaa2'+this.newFacility.name);
    this.newFacility.description=this.newFacilityForm.get('description').value;
    this.newFacility.address=this.newFacilityForm.get('address').value;
    this.newFacility.latitude=this.newFacilityForm.get('latitude').value;
    this.newFacility.longitude=this.newFacilityForm.get('longitude').value;
    this.newFacility.descriptionLocation=this.newFacilityForm.get('descriptionLocation').value;
    this.newFacility.facilityTypeId=this.facilityTypeId;
    this.newFacility.categoryId=this.categoryId;
    this.newFacility.facilityAS=this.fasId;
    this.newFacility.destinationId=this.destinationId;
    let username=this.sessionStorageService.getUserName();
    this.newFacility.agentId=this.sessionStorageService.getUserData().id;
    this.newFacility.image=null;

    this.accommodationService.addFacility(this.newFacility).subscribe(data=>{
      this.newFacilityId=data;
      console.log('Uspesno dodavanje smestaja');
      this.submitted=true;
      this.addFMod=false;
    },
    error=>{
      console.log('Neuspesno dodavanje smestaja')
    });


  }

  addUnitClick(facilityId:Number){
    this.addUMod=true;
    this.addFMod=false;
    this.unitFacilityId=facilityId;
  }

  addUnit(){

    if(this.newUnitForm.invalid){
      alert("Popunite polja sa zvezdicom");
      return;
    }
    this.newUnit.capacity=this.newUnitForm.get('capacity').value;
    this.newUnit.canBeCanceled=this.canBeCanceled;
    this.newUnit.daysBefore=this.newUnitForm.get('daysBefore').value;
    this.newUnit.january=this.newUnitForm.get('january').value;
    this.newUnit.february=this.newUnitForm.get('february').value;
    this.newUnit.march=this.newUnitForm.get('march').value;
    this.newUnit.april=this.newUnitForm.get('april').value;
    this.newUnit.may=this.newUnitForm.get('may').value;
    this.newUnit.june=this.newUnitForm.get('june').value;
    this.newUnit.july=this.newUnitForm.get('july').value;
    this.newUnit.august=this.newUnitForm.get('august').value;
    this.newUnit.september=this.newUnitForm.get('september').value;
    this.newUnit.october=this.newUnitForm.get('october').value;
    this.newUnit.november=this.newUnitForm.get('november').value;
    this.newUnit.december=this.newUnitForm.get('december').value;
    this.newUnit.facilityId=this.unitFacilityId;
    this.newUnit.unitAS=this.uasId;

    

    this.accommodationService.addUnit(this.newUnit).subscribe(data=>{
      console.log('Uspesno ddodata jedinica');
      this.addFMod=false;
      this.addUMod=false;
    },error=>{
      console.log('neuspesno dodavanje unita')
    });
  }

}

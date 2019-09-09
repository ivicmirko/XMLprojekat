import { Component, OnInit,  } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ShareService } from '../service/Share/share.service';
import { Router } from '@angular/router';
import { AccommodationFacility } from '../model/accommodation-facility';
import { SearchFormParams } from '../model/search-form-params';
import { Category } from '../model/category';
import { FacilityAS } from '../model/facility-as';
import { FacilityType } from '../model/facility-type';
import { Profile } from 'selenium-webdriver/firefox';
import { AuthService } from '../service/Auth/auth.service';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';
import { ProfileDTO } from '../model/profile-dto';
import { SifarnikService } from '../service/Sifarnik/sifarnik.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-search-filter',
  templateUrl: './search-filter.component.html',
  styleUrls: ['./search-filter.component.scss']
})
export class SearchFilterComponent implements OnInit {

  searchForm : FormGroup;
  facilities:AccommodationFacility[];
  searchParams:SearchFormParams;
  categories:Category[];
  facilityAS:FacilityAS[];
  facilityTypes:FacilityType[];
  theCheckBox:boolean;
  typesFilter=new Map<String,Number>();
  filtratedFacilities:AccommodationFacility[]=[];
  showingFacilities:AccommodationFacility[]=[];
  loggedUser:Profile;
  length:Number=0;
  destinationName:String="";
  profile:ProfileDTO;
  images:any[]=[];

  constructor(private formBuilder:FormBuilder,private sifarnikService:SifarnikService,private authService:AuthService,
    private shareService:ShareService,private srcResService:SearchReservationService,
    private router:Router,private sanitizer:DomSanitizer) { }

  ngOnInit() {
    this.searchForm=this.formBuilder.group({
      destination: [''],
      startDate:Date,
      endDate:Date,
      rooms:Number,
      persons:Number

    });

    let retrievedObject=localStorage.getItem('params');
    this.searchParams=JSON.parse(retrievedObject);
    this.searchForm.controls['destination'].setValue(this.searchParams.destinationName);
    this.searchForm.controls['startDate'].setValue(this.searchParams.checkIn);
    this.searchForm.controls['endDate'].setValue(this.searchParams.checkOut);
    this.searchForm.controls['persons'].setValue(this.searchParams.numPersons);
    
    this.srcResService.getFreeFacilities(this.searchParams).subscribe(data=>{
      this.facilities=data;
      this.showingFacilities=data;
      this.length=this.facilities.length;

      for(let ij=0; ij< this.facilities.length;ij++){
        console.log(this.images);
        let objectURL = 'data:image/jpeg;base64,' + this.facilities[ij].image;
        this.images.push(this.sanitizer.bypassSecurityTrustUrl(objectURL));
      console.log(this.images);
    }
    });
    
    if(this.facilities != null){
      console.log('nn');
    }
    
    this.destinationName=this.searchParams.destinationName;      

    this.sifarnikService.getAllFacilityTypes().subscribe(data=>{
      this.facilityTypes=data;
    });

    this.sifarnikService.getAllCategories().subscribe(data=>{
      this.categories=data;
    });

    this.sifarnikService.getAllfas().subscribe(data=>{
      this.facilityAS=data;
    });

    this.sifarnikService.getAllFacilityTypes().subscribe(data=>{
      this.facilityTypes=data;
    });

      this.getLogged();
      //ovde je kraj init a
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

  //filtriranje
  typeFilterChanged(e,id:string){
    if(e.target.checked){
      this.typesFilter.set(id,1);

    }else{
      this.typesFilter.delete(id);
    }
    
    console.log(id+"aaa");
    console.log(this.typesFilter);
    this.showingFacilities=this.facilities;
    this.filtratedFacilities=[];
    //filtriranje
    for(let i=0; i<this.facilities.length;i++){
      for(let key of Array.from( this.typesFilter.keys())){
        
        if(this.facilities[i].facilityType.name === key){
          if(!this.filtratedFacilities.includes(this.facilities[i])){
            this.filtratedFacilities.push(this.facilities[i]);        
          
          }
          
        }

        if(this.facilities[i].category.name === key){
          if(!this.filtratedFacilities.includes(this.facilities[i])){
            this.filtratedFacilities.push(this.facilities[i]);
          }
        }

        for(let k=0 ; k< this.facilities[i].facilityAS.length; k++){
          if(this.facilities[i].facilityAS[k].name === key){
            console.log("muuu");
            if(!this.filtratedFacilities.includes(this.facilities[i])){
              this.filtratedFacilities.push(this.facilities[i]);
            }
          }
        }
      }
    }
  
    // ako bi hteli da filter funkcionise kao presek onda bi trebalo da za svaku vrstu filtera postoji dvostruka
    // for petlja gde je u prvu ulaz svi, u drugu izlaz iz prve itd.
    
    this.showingFacilities=this.filtratedFacilities;
    if(this.typesFilter.size==0){
      this.showingFacilities=this.facilities;
    }
  }

  detaljnije(fac:AccommodationFacility){
    this.searchParams= new SearchFormParams(this.searchForm.get('destination').value,this.searchForm.get('startDate').value,
    this.searchForm.get('endDate').value,this.searchForm.get('persons').value);
    localStorage.setItem('params',JSON.stringify(this.searchParams));


    if(this.profile==null){
      this.router.navigate(["/login"]);
      return;
    }
    localStorage.setItem('idfac',JSON.stringify(fac.id));
    this.router.navigate(['/searchunits']);

  }

  searchAgain(){
    if((this.searchForm.get('startDate').value > this.searchForm.get('endDate').value)){
      alert("Datum napustanja smestaja mora biti posle datuma checkIn-a!");
      return;
    }

    this.searchParams= new SearchFormParams(this.searchForm.get('destination').value,this.searchForm.get('startDate').value,
    this.searchForm.get('endDate').value,this.searchForm.get('persons').value);
    localStorage.setItem('params',JSON.stringify(this.searchParams));
    
    this.srcResService.getFreeFacilities(this.searchParams).subscribe(data=>
      {
        console.table(data);
        this.facilities=data;
        this.showingFacilities=data;
        this.length=this.facilities.length;
        // this.sharingService.sendNewFacilities(data);
        // this.sharingService.sendSearchFormParams(this.searchParams);
      });
  }

  rasteCena(){
    this.facilities.sort((a:AccommodationFacility,b:AccommodationFacility)=> {
      return Number(a.minPrice)-Number(b.minPrice);
    });
  }

  padaCena(){
    this.facilities.sort((a:AccommodationFacility,b:AccommodationFacility)=> {
      return Number(b.minPrice)-Number(a.minPrice);
    });
  }

  opadaOcena(){
    this.showingFacilities.sort((a:AccommodationFacility,b:AccommodationFacility)=> {
      return Number(Number(b.rating)/Number(b.voters))-Number(Number(a.rating)/Number(a.voters));
    });
  }

  rasteOcena(){
    this.showingFacilities.sort((a:AccommodationFacility,b:AccommodationFacility)=> {
      return Number(Number(a.rating)/Number(a.voters))-Number(Number(b.rating)/Number(b.voters));
    });
  }

  // najbliziCentru(){
  //   this.showingFacilities.sort((a:AccommodationFacility,b:AccommodationFacility)=>{
  //       return Number(a.destination.longitude)-Number(b.)
  //   });
    
  // }

  // getDistance(af:AccommodationFacility){
  //   let l=af.location;
    
  //   let distnace=Number(af.destination.longitude)- Number(af.location)
  // }
}

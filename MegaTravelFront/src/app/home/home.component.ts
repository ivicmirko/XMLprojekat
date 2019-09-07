import { Component, OnInit, asNativeElements } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { SearchFormParams } from '../model/search-form-params';
import { Router } from '@angular/router';
import { AuthService } from '../service/Auth/auth.service';
import { ProfileDTO } from '../model/profile-dto';
import { ShareService } from '../service/Share/share.service';
import { SearchReservationService } from '../service/SearchReservation/search-reservation.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  searchForm: FormGroup;
  searchParams:SearchFormParams;
  minDate=new Date();
  minEndDate=new Date().setDate(this.minDate.getDate() + 1);
  profile:ProfileDTO;
  anyLogged=false;
  adminLogged=false;

  constructor(private formBuilder:FormBuilder,private router: Router,private authService:AuthService,
    private shareService:ShareService,private srcResService: SearchReservationService) {
      this.getLogged();
         }

  ngOnInit() {

    this.searchForm=this.formBuilder.group({
      destination: '',
      startDate:Date,
      endDate:Date,
      rooms:Number,
      persons:Number
    });

    this.getLogged();

    localStorage.removeItem('params');
    localStorage.removeItem('idfac');
    console.log(new Date);
    this.searchForm.controls['rooms'].setValue(1);
    this.searchForm.controls['persons'].setValue(1);
  }

  onSubmitt(){
    console.log(this.searchForm.get('startDate').value);

    if((this.searchForm.get('startDate').value > this.searchForm.get('endDate').value)){
      alert("Datum napustanja smestaja mora biti posle datuma checkIn-a!");
      return;
    }

    if(this.searchForm.get('destination').value == ''){
      alert("Unesite zeljenu destinaciju");
      return;
    }

    // if(this.searchForm.get('startDate') == null ){
    //   alert("Unesite datum check In-a");
    //   return;
    // }

    // if(this.searchForm.get('endDate') == null){
    //   alert("Unesite datum checkOut");
    //   return;
    // }

    this.searchParams= new SearchFormParams(this.searchForm.get('destination').value,this.searchForm.get('startDate').value,
    this.searchForm.get('endDate').value,this.searchForm.get('persons').value);
    console.log('polece');
    this.srcResService.getFreeFacilities(this.searchParams).subscribe(data=>
      {
        console.table(data);
        this.shareService.sendFacilities(data);
        //this.sharingService.sendSearchFormParams(this.searchParams);
      });
    localStorage.setItem('params',JSON.stringify(this.searchParams));
    this.router.navigate(["/search"]);
  }

  getLogged(){
    console.log('loog');
    this.authService.getLogged().subscribe(data=>{
      console.log('usa');
      this.profile=data;
      this.anyLogged=true;
      this.shareService.sendIsLogged(this.anyLogged);
      this.shareService.sendProfile(this.profile);
      let role=this.profile.authorities[0];
      if(role == 'admin'){
        this.adminLogged=true;
      }else{
        this.adminLogged=false;
      }
    },
    error=>{
      this.profile=null;
      this.anyLogged=false;
      this.adminLogged=false;
    });
  }

}

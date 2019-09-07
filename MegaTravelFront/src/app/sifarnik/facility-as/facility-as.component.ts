import { Component, OnInit } from '@angular/core';
import { FacilityAS } from 'src/app/model/facility-as';
import { SifarnikService } from 'src/app/service/Sifarnik/sifarnik.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-facility-as',
  templateUrl: './facility-as.component.html',
  styleUrls: ['./facility-as.component.scss']
})
export class FacilityASComponent implements OnInit {

  facilityAS:FacilityAS[];
  addMod=false;
  fasForm:FormGroup;
  submitted=false;

  constructor(private sifarnikService:SifarnikService,private formBuilder:FormBuilder) {
   }

  ngOnInit() {
    this.sifarnikService.getAllfas().subscribe(data=>{
      this.facilityAS=data;
    });

    this.fasForm=this.formBuilder.group({
      name:['',Validators.required]
    });
  }

  addFASClick(){
    this.addMod=true;
  }

  addFAS(){
    let name=this.fasForm.get('name').value;
    console.log(name);

    this.submitted=true;

    if(this.fasForm.invalid){
      return;
    }


    let fas=new FacilityAS(2,name,null);
 
    this.sifarnikService.addFas(fas).subscribe(data=>{
      this.facilityAS.push(data);
    });

    this.submitted=true;
    this.fasForm.get('name').setValue('');
    this.addMod=false;
    this.submitted=false;
  }

  deleteFAS(id:Number){
    console.log(id);
    this.sifarnikService.deleteFas(id).subscribe(data=>{
      this.sifarnikService.getAllfas().subscribe(data=>{
        this.facilityAS=data;
      })
    })
  }

}

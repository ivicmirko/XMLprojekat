import { Component, OnInit } from '@angular/core';
import { SifarnikService } from 'src/app/service/Sifarnik/sifarnik.service';
import { FacilityType } from 'src/app/model/facility-type';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UnitAS } from 'src/app/model/unit-as';

@Component({
  selector: 'app-facility-type',
  templateUrl: './facility-type.component.html',
  styleUrls: ['./facility-type.component.scss']
})
export class FacilityTypeComponent implements OnInit {

  facilityTypes:FacilityType[];
  addMod=false;
  typeForm:FormGroup;
  submitted=false;

  constructor(private sifarnikService:SifarnikService,private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.sifarnikService.getAllFacilityTypes().subscribe(data=>{
      this.facilityTypes=data;
    });

    this.typeForm=this.formBuilder.group({
      name:['',Validators.required]
    });
  
  }

  addTypeClick(){
    this.addMod=true;
  }

  addType(){
    let name=this.typeForm.get('name').value;
    console.log(name);

    this.submitted=true;

    if(this.typeForm.invalid){
      return;
    }


    let type=new FacilityType(2,name,null);
 
    this.sifarnikService.addType(type).subscribe(data=>{
      this.facilityTypes.push(data);
    });

    this.submitted=true;
    this.typeForm.get('name').setValue('');
    this.addMod=false;
    this.submitted=false;
  }

  deleteType(id:Number){
    console.log(id);
    this.sifarnikService.deleteType(id).subscribe(data=>{
      this.sifarnikService.getAllFacilityTypes().subscribe(data=>{
        this.facilityTypes=data;
      })
    })
  }

}

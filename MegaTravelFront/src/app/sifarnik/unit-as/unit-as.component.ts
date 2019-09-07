import { Component, OnInit } from '@angular/core';
import { UnitAS } from 'src/app/model/unit-as';
import { SifarnikService } from 'src/app/service/Sifarnik/sifarnik.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-unit-as',
  templateUrl: './unit-as.component.html',
  styleUrls: ['./unit-as.component.scss']
})
export class UnitASComponent implements OnInit {

  unitAS:UnitAS[];
  addMod=false;
  uasForm:FormGroup;
  submitted=false;

  constructor(private sifarnikService:SifarnikService,private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.sifarnikService.getAlluas().subscribe(data=>{
      this.unitAS=data;
    });

    this.uasForm=this.formBuilder.group({
      name:['',Validators.required]
    });
  }

  addUASClick(){
    this.addMod=true;
  }

  addUAS(){
    let name=this.uasForm.get('name').value;
    console.log(name);

    this.submitted=true;

    if(this.uasForm.invalid){
      return;
    }


    let uas=new UnitAS(2,name);
 
    this.sifarnikService.addUas(uas).subscribe(data=>{
      this.unitAS.push(data);
    });

    this.submitted=true;
    this.uasForm.get('name').setValue('');
    this.addMod=false;
    this.submitted=false;
  }

  deleteUAS(id:Number){
    console.log(id);
    this.sifarnikService.deleteUas(id).subscribe(data=>{
      this.sifarnikService.getAlluas().subscribe(data=>{
        this.unitAS=data;
      })
    })
  }

}

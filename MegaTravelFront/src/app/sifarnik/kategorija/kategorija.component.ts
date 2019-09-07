import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/model/category';
import { SifarnikService } from 'src/app/service/Sifarnik/sifarnik.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kategorija',
  templateUrl: './kategorija.component.html',
  styleUrls: ['./kategorija.component.scss']
})
export class KategorijaComponent implements OnInit {

  categories:Category[];
  addMod=false;
  catForm:FormGroup;
  submitted=false;
  
  constructor(private sifarnikService:SifarnikService, private formBuilder:FormBuilder,private router:Router) { }

  ngOnInit() {
    this.sifarnikService.getAllCategories().subscribe(data=>{
      this.categories=data;
    });

    this.catForm=this.formBuilder.group({
      name:['', Validators.required]
    });
  }

  addCategoryClick(){
    console.log('tu smo');
    this.addMod=true;
  }

  addCategory(){
    let name=this.catForm.get('name').value;
    console.log(name);

    this.submitted=true;

    if(this.catForm.invalid){
      return;
    }


    let category=new Category(2,name,null);
 
    this.sifarnikService.addCategory(category).subscribe(data=>{
      this.categories.push(data);
    });

    this.submitted=true;
    this.catForm.get('name').setValue('');
    this.addMod=false;
    this.submitted=false;
  }

  deleteCategory(id:Number){
    console.log(id);
    this.sifarnikService.deleteCategory(id).subscribe(data=>{
      this.sifarnikService.getAllCategories().subscribe(data=>{
        this.categories=data;
      })
    })
  }

}

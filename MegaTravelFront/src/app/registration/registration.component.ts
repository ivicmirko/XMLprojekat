import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../service/Auth/auth.service';
import { RegisterParams } from '../model/register-params';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  registrationForm: FormGroup;
  submitted=false;
  success=false;
  messageOk="Uspesno ste se registrovali!";
  isEqual:boolean=true;
  registrationParams:RegisterParams;
  isSignedUp=false;

  constructor(private formBuilder: FormBuilder, private authService:AuthService) { }

  ngOnInit() {

    this.registrationForm = this.formBuilder.group({
      username:['',Validators.required],
      name: ['', Validators.required],
      surname: ['', Validators.required],
      password: ['', Validators.required],
      rePassword: ['', Validators.required],
      telNum: ['', Validators.required],
      address:['',Validators.required],
      email:['',Validators.required]
    });
  }

  signUp(){
    this.submitted=true;

    if(this.registrationForm.invalid){
      return;
    }

    if(!(this.registrationForm.get('password').value === this.registrationForm.get('rePassword').value)){
      this.isEqual=false;
      alert('Lozinka i potvrda lozinke moraju biti identicni!');
      return;
    }

    this.success = true;
    console.log("muuuuu");
    this.registrationParams=new RegisterParams(this.registrationForm.get('username').value,this.registrationForm.get('name').value,
    this.registrationForm.get('surname').value,this.registrationForm.get('email').value,this.registrationForm.get('address').value,
    this.registrationForm.get('telNum').value,this.registrationForm.get('password').value);

    console.table(this.registrationParams);

    this.authService.signUp(this.registrationParams).subscribe(
      data=>
      {
        console.log(data);
        this.isSignedUp=true;

      },
      error=>
      {
        console.log(error);
        this.isSignedUp=false;
      }
      
    )
  }

}

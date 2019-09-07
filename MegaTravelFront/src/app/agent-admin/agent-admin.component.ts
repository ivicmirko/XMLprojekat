import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/Auth/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AgentDTO } from '../model/agent-dto';
import { AgentAdd } from '../model/agent-add';

@Component({
  selector: 'app-agent-admin',
  templateUrl: './agent-admin.component.html',
  styleUrls: ['./agent-admin.component.scss']
})
export class AgentAdminComponent implements OnInit {

  agentForm:FormGroup;
  addMod=false;
  agents:AgentDTO[];
  submitted=false;
  success=false;
  agentParams:AgentAdd;

  constructor(private authService:AuthService, private formBuilder:FormBuilder) { }

  ngOnInit() {
    this.agentForm=this.formBuilder.group({
      name:['',Validators.required],
      surname:['',Validators.required],
      username:['',Validators.required],
      address:['',Validators.required],
      phoneNum:['',Validators.required],
      pib:['',Validators.required],
      email:['',Validators.required]
    });

    this.authService.getAllAgents().subscribe(data=>{
      this.agents=data;
    })
  }

  addAgentClick(){
    this.addMod=true;
  }

  addAgent(){
    console.log('usao');
    this.submitted=true;

    if(this.agentForm.invalid){
      return;
    }

    console.log('isao1111')
    this.success = true;
    console.log("muuuuu");
    this.agentParams=new AgentAdd(this.agentForm.get('username').value,this.agentForm.get('name').value,
    this.agentForm.get('surname').value,this.agentForm.get('email').value,this.agentForm.get('address').value,
    this.agentForm.get('phoneNum').value,"123",this.agentForm.get('pib').value);

    console.table(this.agentParams);

    this.authService.addAgent(this.agentParams).subscribe(
      data=>
      {
        this.authService.getAllAgents().subscribe(data=>{
          this.agents=data;
        });

      },
      error=>
      {
        console.log(error);
      }
      
    )
    this.addMod=false;
    this.submitted=false;
  }

}

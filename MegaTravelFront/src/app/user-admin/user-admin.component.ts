import { Component, OnInit } from '@angular/core';
import { UserDTO } from '../model/user-dto';
import { SifarnikService } from '../service/Sifarnik/sifarnik.service';
import { AuthService } from '../service/Auth/auth.service';

@Component({
  selector: 'app-user-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['./user-admin.component.scss']
})
export class UserAdminComponent implements OnInit {

  users:UserDTO[];

  constructor(private authService:AuthService) { }

  ngOnInit() {
    this.authService.getAllUsers().subscribe(data=>{
      this.users=data;
    });
  }

  blockUser(username:String){
    this.authService.blockUser(username).subscribe(data=>{
      this.authService.getAllUsers().subscribe(data=>{
        this.users=data;
      });
    });
  }

  unblockUser(username:String){
    this.authService.unblockUser(username).subscribe(data=>{
      this.authService.getAllUsers().subscribe(data=>{
        this.users=data;
      });
    });
  }

  deleteUser(username:String){
    this.authService.deleteUser(username).subscribe(data=>{
      this.authService.getAllUsers().subscribe(data=>{
        this.users=data;
      });
    });
  }

}

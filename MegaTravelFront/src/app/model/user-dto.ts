export class UserDTO {
    username:string;
    email:string;
    name:string;
    surname:string;
    address:string;
    phoneNum:string;
    isEnabled:boolean;
    isNotRemoved:boolean;

    constructor(username:string, email:string, name:string, surname:string, address:string,
        phoneNum:string,isEnabled:boolean, isNotRemoved:boolean){
            this.username=username;
            this.name=name;
            this.surname=surname;
            this.email=email;
            this.phoneNum=phoneNum;
            this.address=address;
            this.isEnabled=isEnabled;
            this.isNotRemoved=isNotRemoved;
        }


}

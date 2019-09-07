export class RegisterParams {
    private username:string;
    private name:string;
    private surname:string;
    private email:string;
    private address:string;
    private phoneNum:string;
    private password:string;

    constructor(username:string,name:string,surname:string,email:string,
        address:string,phoneNum:string,password:string){
            this.username=username;
            this.name=name;
            this.surname=surname;
            this.email=email;
            this.address=address;
            this.phoneNum=phoneNum;
            this.password=password;
        }
}

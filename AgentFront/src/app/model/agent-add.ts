export class AgentAdd {
    private username:string;
    private name:string;
    private surname:string;
    private email:string;
    private address:string;
    private phoneNum:string;
    private password:string;
    private pib:Number;

    constructor(username:string,name:string,surname:string,email:string,
        address:string,phoneNum:string,password:string,pib:Number){
            this.username=username;
            this.name=name;
            this.surname=surname;
            this.email=email;
            this.address=address;
            this.phoneNum=phoneNum;
            this.password=password;
            this.pib=pib;
        }
}

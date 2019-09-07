export class AgentDTO {
    name:string;
    surname:string;
    username:string;
    pib:Number;

    constructor(username:string, name:string, surname:string, pib:Number){
            this.username=username;
            this.surname=surname;
            this.name=name;
            this.pib=pib;
        }
}

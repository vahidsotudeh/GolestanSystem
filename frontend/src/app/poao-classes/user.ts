export class User {
    id:number;
    userName:string;
    firstName:string;
    lastName:string;
    password:string;
    email:string;
    enabled:boolean;
    roles:Array<Role>;
}
export class Role{
    id:number;
    name:string;
    permissions:Array<Permission>;
}
export class Permission{
    id:number;
    name:string;
}

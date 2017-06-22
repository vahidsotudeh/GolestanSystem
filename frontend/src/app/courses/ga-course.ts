export class GaCourse {
    id:number;
    name:string;
    code:string;
    groups:GaCourseGroups[];
    preRequiredLectures:GaCourseGroups[];
    practicalUnitCount:number;
    theoreticalUnitCount:number;
    constructor(id,name,code,groups,predefs,practs,theors){
        this.id=id;
        this.name=name;
        this.code=code;
        this.groups=groups;
        this.preRequiredLectures=predefs;
        this.practicalUnitCount=practs;
        this.theoreticalUnitCount=theors;
    }
}
export class GaCourseGroups{
    id:number;
    name:string;
}

export class GaCourse {
    id:number;
    name:String;
    code:String;
    groups:GaCourseGroups[];
    preRequiredLectures:GaCourseGroups[];
    practicalUnitCount:number;
    theoreticalUnitCount:number;
}
export class GaCourseGroups{
    id:number;
    name:String;
}

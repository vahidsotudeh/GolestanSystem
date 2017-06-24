import {GaCourse} from '../courses/ga-course';
import {Term} from '../terms/term';
import {Master} from './master';

export class Lecture{
    id:number;
    term:Term;
    course:GaCourse;
    code:string;
    roomNumber:number;
    master:Master
    
}
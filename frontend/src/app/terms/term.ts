import {GaCourse} from '../courses/ga-course';
import {Lecture} from '../poao-classes/lecture';
export class Term {
    id:number;
    year:number;
    semester:number
    lectures:Array<Lecture>;

}

import {GaCourse} from '../courses/ga-course';
import {Term} from '../terms/term';
import {Master} from './master';
import {LectureTime} from './lecture-time';
export class Lecture{
    id:number;
    term:Term;
    course:GaCourse;
    code:string;
    roomNumber:number;
    master:Master
    lectureTimes:Array<LectureTime>;
}
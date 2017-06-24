import {Lecture} from './lecture';
import {User} from './user';
export class Master extends User {
    lectures:Array<Lecture>;
}

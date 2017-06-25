import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassStudentListComponent } from './class-student-list.component';

describe('ClassStudentListComponent', () => {
  let component: ClassStudentListComponent;
  let fixture: ComponentFixture<ClassStudentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClassStudentListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassStudentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

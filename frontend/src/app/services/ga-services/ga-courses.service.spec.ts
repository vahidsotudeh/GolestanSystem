import { TestBed, inject } from '@angular/core/testing';

import { GaCoursesService } from './ga-courses.service';

describe('GaCoursesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GaCoursesService]
    });
  });

  it('should be created', inject([GaCoursesService], (service: GaCoursesService) => {
    expect(service).toBeTruthy();
  }));
});

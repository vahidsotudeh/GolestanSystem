import { TestBed, inject } from '@angular/core/testing';

import { GaTermsService } from './ga-terms.service';

describe('GaTermsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GaTermsService]
    });
  });

  it('should be created', inject([GaTermsService], (service: GaTermsService) => {
    expect(service).toBeTruthy();
  }));
});

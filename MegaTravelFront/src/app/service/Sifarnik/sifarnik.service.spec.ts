import { TestBed } from '@angular/core/testing';

import { SifarnikService } from './sifarnik.service';

describe('SifarnikService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SifarnikService = TestBed.get(SifarnikService);
    expect(service).toBeTruthy();
  });
});

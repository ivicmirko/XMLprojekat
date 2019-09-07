import { TestBed } from '@angular/core/testing';

import { SearchReservationService } from './search-reservation.service';

describe('SearchReservationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchReservationService = TestBed.get(SearchReservationService);
    expect(service).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FacilityASComponent } from './facility-as.component';

describe('FacilityASComponent', () => {
  let component: FacilityASComponent;
  let fixture: ComponentFixture<FacilityASComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FacilityASComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FacilityASComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

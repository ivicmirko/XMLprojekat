import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitASComponent } from './unit-as.component';

describe('UnitASComponent', () => {
  let component: UnitASComponent;
  let fixture: ComponentFixture<UnitASComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnitASComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnitASComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

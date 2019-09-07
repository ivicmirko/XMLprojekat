import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentReservationComponent } from './agent-reservation.component';

describe('AgentReservationComponent', () => {
  let component: AgentReservationComponent;
  let fixture: ComponentFixture<AgentReservationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgentReservationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgentReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

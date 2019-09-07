import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchUnitsComponent } from './search-units.component';

describe('SearchUnitsComponent', () => {
  let component: SearchUnitsComponent;
  let fixture: ComponentFixture<SearchUnitsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchUnitsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchUnitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

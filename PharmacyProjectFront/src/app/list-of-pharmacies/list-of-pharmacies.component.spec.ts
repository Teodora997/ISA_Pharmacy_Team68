import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListOfPharmaciesComponent } from './list-of-pharmacies.component';

describe('ListOfPharmaciesComponent', () => {
  let component: ListOfPharmaciesComponent;
  let fixture: ComponentFixture<ListOfPharmaciesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListOfPharmaciesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListOfPharmaciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

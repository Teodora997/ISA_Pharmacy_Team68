import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DefineDiscountComponent } from './define-discount.component';

describe('DefineDiscountComponent', () => {
  let component: DefineDiscountComponent;
  let fixture: ComponentFixture<DefineDiscountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DefineDiscountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DefineDiscountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

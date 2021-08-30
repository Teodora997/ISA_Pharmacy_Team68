import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhadminDermatologistComponent } from './phadmin-dermatologist.component';

describe('PhadminDermatologistComponent', () => {
  let component: PhadminDermatologistComponent;
  let fixture: ComponentFixture<PhadminDermatologistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhadminDermatologistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PhadminDermatologistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

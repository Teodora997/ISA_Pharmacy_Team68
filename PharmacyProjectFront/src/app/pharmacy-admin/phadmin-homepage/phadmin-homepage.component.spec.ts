import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhadminHomepageComponent } from './phadmin-homepage.component';

describe('PhadminHomepageComponent', () => {
  let component: PhadminHomepageComponent;
  let fixture: ComponentFixture<PhadminHomepageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhadminHomepageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PhadminHomepageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

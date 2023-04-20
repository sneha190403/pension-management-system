import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PmsLoginComponent } from './pms-login.component';

describe('PmsLoginComponent', () => {
  let component: PmsLoginComponent;
  let fixture: ComponentFixture<PmsLoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PmsLoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PmsLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

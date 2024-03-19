import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentUnoComponent } from './component-uno.component';

describe('ComponentUnoComponent', () => {
  let component: ComponentUnoComponent;
  let fixture: ComponentFixture<ComponentUnoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComponentUnoComponent]
    });
    fixture = TestBed.createComponent(ComponentUnoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

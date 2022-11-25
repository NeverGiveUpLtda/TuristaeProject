import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InserirTurismoComponent } from './inserir-turismo.component';

describe('InserirTurismoComponent', () => {
  let component: InserirTurismoComponent;
  let fixture: ComponentFixture<InserirTurismoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InserirTurismoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InserirTurismoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

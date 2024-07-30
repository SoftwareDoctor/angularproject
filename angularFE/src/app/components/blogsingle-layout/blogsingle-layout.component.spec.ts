import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogsingleLayoutComponent } from './blogsingle-layout.component';

describe('BlogsingleLayoutComponent', () => {
  let component: BlogsingleLayoutComponent;
  let fixture: ComponentFixture<BlogsingleLayoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BlogsingleLayoutComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BlogsingleLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

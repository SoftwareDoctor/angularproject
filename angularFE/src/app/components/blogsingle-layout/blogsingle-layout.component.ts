import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BlogService } from '../../service/blog.service';
import { Blog } from '../../models/blog.model';
import { HttpErrorResponse } from '@angular/common/http';
import { Location } from '@angular/common';

@Component({
  selector: 'app-blogsingle-layout',
  templateUrl: './blogsingle-layout.component.html',
  styleUrls: ['./blogsingle-layout.component.css']
})
export class BlogsingleLayoutComponent implements OnInit {
  article: Blog | null = null;
  errorMessage: string = 'Articolo non trovato';

  constructor(
    private route: ActivatedRoute,
    private blogService: BlogService,
    private location: Location
  ) { }

  ngOnInit(): void {
    const title = this.route.snapshot.paramMap.get('title'); // Recupera il parametro dalla rotta
    if (title) {
      this.blogService.getArticleByTitle(title).subscribe(
        (data: Blog) => {
          this.article = data;
        },
        (error: HttpErrorResponse) => {
          console.error(this.errorMessage);
        }
      );
    }
  }

  goBack(): void {
    this.location.back();  // Naviga alla pagina precedente
  }
}

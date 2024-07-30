import { Component, OnInit } from '@angular/core';
import { BlogService } from '../../service/blog.service';
import { Blog } from '../../models/blog.model';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  articles: Blog[] = [];
  selectedArticle: Blog | null = null;
  noArticlesMessage: string = 'Blog in costruzione';
  searchName: string = '';
  noArticleMessageByTag: string = 'Nessun articolo trovato con il tag cercato';
  errorMessage: string | null = null;

  constructor(private blogService: BlogService) { }

  ngOnInit(): void {
    this.loadAllArticles();
  }

  private loadAllArticles(): void {
    this.blogService.getAllArticles().subscribe(
      (data: Blog[]) => {
        this.articles = data;
        this.errorMessage = this.articles.length === 0 ? this.noArticlesMessage : null;
      },
      (error: HttpErrorResponse) => {
        console.error(this.noArticlesMessage, error);
        this.errorMessage = this.noArticlesMessage;
      }
    );
  }

  viewArticle(article: Blog): void {
    this.selectedArticle = article;
  }

  searchByTag(): void {
    if (this.searchName.trim()) {
      this.blogService.getArticlesSearchByTag(this.searchName).subscribe(
        (data: Blog[]) => {
          this.articles = data;
          this.errorMessage = data.length === 0 ? this.noArticleMessageByTag : null;
        },
        (error: HttpErrorResponse) => {
          console.error('Errore durante la ricerca', error);
          this.errorMessage = 'Si è verificato un errore durante la ricerca.';
        }
      );
    } else {
      this.loadAllArticles();
    }
  }
}

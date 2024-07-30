import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Blog } from '../models/blog.model';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  private apiUrl = 'http://localhost:8080/api/v1/blog/';

  constructor(private http: HttpClient) { }

  // Metodo per ottenere tutti gli articoli
  getAllArticles(): Observable<Blog[]> {
    return this.http.get<Blog[]>(`${this.apiUrl}all`);
  }

  // Metodo per ottenere un articolo specifico
getArticleByTitle(title: string): Observable<Blog> {
  return this.http.get<Blog>(`${this.apiUrl}${encodeURIComponent(title)}`);
}

getArticlesSearchByTag(tag: string): Observable<Blog[]> {
  const url = `${this.apiUrl}all/bytag/${encodeURIComponent(tag)}`;
  return this.http.get<Blog[]>(url);
}

}

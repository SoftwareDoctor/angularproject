// src/app/service/resume.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams  } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Resume } from '../models/resume.model';

@Injectable({
  providedIn: 'root'
})
export class ResumeService {
  private apiUrl = 'http://localhost:8080/api/v1/resume/';

  constructor(private http: HttpClient) { }


  downloadResume(title:string): Observable<Blob> {
    const param = new HttpParams().set('title', title);
    return this.http.get(`${this.apiUrl}?title=${title}`, { responseType: 'blob' });
  }
}

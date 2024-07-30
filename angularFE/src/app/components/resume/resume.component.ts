import { Component } from '@angular/core';
import { ResumeService } from '../../service/resume.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent {
  constructor(private resumeService: ResumeService) { }

  downloadFile(title: string): void {
    this.resumeService.downloadResume(title).subscribe(
      (blob: Blob) => {
        if (blob && blob.size > 0) {
          // Crea un URL per il Blob
          const url = window.URL.createObjectURL(blob);
          const a = document.createElement('a');
          a.href = url;
          a.download = `${title}.pdf`;
          document.body.appendChild(a);
          a.click();
          document.body.removeChild(a);
          window.URL.revokeObjectURL(url);
        } else {
          console.warn('Il file richiesto è vuoto o non esiste.');
        }
      },
      (error: HttpErrorResponse) => {
        console.error('Errore nel download del file:', error);
      }
    );
  }
}

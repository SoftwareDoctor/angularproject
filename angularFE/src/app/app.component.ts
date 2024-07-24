import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
   title = 'Software Doctor';
   subtitle: string = 'Software Doctor';

  constructor(private router: Router) { }

  navigateToHome(): void {
    this.router.navigate(['/home']);
  }
}




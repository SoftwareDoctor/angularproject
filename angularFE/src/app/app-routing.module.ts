import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ResumeComponent } from './components/resume/resume.component';
import { BlogComponent } from './components/blog/blog.component';
import { BlogsingleLayoutComponent } from './components/blogsingle-layout/blogsingle-layout.component';  // Assicurati di usare il nome corretto
import { AppLayoutComponent } from './components/app-layout/app-layout.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },

 {
     path: '',
     component: AppLayoutComponent,
     children: [
       { path: 'resume', component: ResumeComponent },
       { path: 'home', component: HomeComponent }
     ]
   },
  { path: 'blog', component: BlogComponent },
  { path: 'blog/:title', component: BlogsingleLayoutComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }








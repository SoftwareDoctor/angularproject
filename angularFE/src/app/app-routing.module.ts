import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';  // Importa HomeComponent
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },  // Rotta per la home page
  { path: '', redirectTo: '/home', pathMatch: 'full' },  // Redirect alla home per il percorso di base
  { path: 'products', component: ProductComponent },
  { path: '**', redirectTo: '/home' }  // Redirect alla home per qualsiasi rotta non trovata
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

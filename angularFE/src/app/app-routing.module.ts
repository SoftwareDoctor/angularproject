import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';  // Importa HomeComponent
import { ProductComponent } from './product/product.component';

const routes: Routes = [
  { path: '', component: HomeComponent },  // Rotta per la home page
  { path: 'products', component: ProductComponent },
//   { path: '**', redirectTo: '' }  // Redirect alla home per qualsiasi rotta non trovata
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

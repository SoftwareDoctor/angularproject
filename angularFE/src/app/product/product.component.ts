import { Component, OnInit, Inject } from '@angular/core';
import { ProductService } from '../service/product.service';
import { Product } from '../models/product.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: Product[] = [];
  searchName: string = '';

  constructor(@Inject(ProductService) private productService: ProductService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(
      (data: Product[]) => {
        this.products = data;
      },
      (error: any) => {
        console.error('Error fetching products:', error);
      }
    );
  }

  searchProducts(): void {
    if (this.searchName.trim()) {
      this.productService.getProductSearchByName(this.searchName).subscribe(
        (data: Product[]) => {
          this.products = data;
        },
        (error: any) => {
          console.error('Error searching products by name:', error);
        }
      );
    } else {
      this.loadProducts();
    }
  }
}

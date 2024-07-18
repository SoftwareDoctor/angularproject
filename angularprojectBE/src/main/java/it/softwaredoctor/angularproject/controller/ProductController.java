package it.softwaredoctor.angularproject.controller;

import it.softwaredoctor.angularproject.model.Product;
import it.softwaredoctor.angularproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("products/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List <Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("products/searchName/")
    public ResponseEntity<List<Product>> getProductSearch(@RequestParam String searchName) {
        List <Product> products = productService.getProductSearch(searchName);
        return ResponseEntity.ok().body(products);
    }

}

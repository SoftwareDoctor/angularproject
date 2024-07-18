package it.softwaredoctor.angularproject.service;

import it.softwaredoctor.angularproject.model.Product;
import it.softwaredoctor.angularproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductSearch(String searchName) {
        if (searchName == null || searchName.isEmpty()) {
            return productRepository.findAll();
        } else {
            return productRepository.findByNameContainingIgnoreCase(searchName);
        }
    }

//    public List<Product> getProductSearch(String searchName) {
//        if (searchName == null || searchName.isEmpty()) {
//            return productRepository.findAll();
//        } else {
//            return productRepository.findByNameContaining(searchName);
//        }
//    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }



//    public List<Product> getProductSearch(String searchName) {
//        List<Product> allProducts = productRepository.findAll();
//        if (searchName == null || searchName.isEmpty()) {
//            return allProducts;
//        } else {
//            String lowerCaseSearchName = searchName.toLowerCase();
//            return allProducts.stream()
//                    .filter(product -> product.getName().toLowerCase().contains(lowerCaseSearchName))
//                    .collect(Collectors.toList());
//        }
//    }
}

package br.com.tamboril.controllers;

import br.com.tamboril.domain.product.Product;
import br.com.tamboril.domain.product.ProductResponseDTO;
import br.com.tamboril.repositories.ProductRepository;
import br.com.tamboril.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProducts() {
        List<ProductResponseDTO> products = service.getAllProductsDTO();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("id") Long id) {
        ProductResponseDTO productDTO = service.getProductDTOById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }

}

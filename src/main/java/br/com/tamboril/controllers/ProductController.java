package br.com.tamboril.controllers;

import br.com.tamboril.domain.product.Product;
import br.com.tamboril.domain.product.ProductResponseDTO;
import br.com.tamboril.repositories.ProductRepository;
import br.com.tamboril.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ProductResponseDTO> getProducts() {
        return service.getAllProductsDTO();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return service.getProductDTOById(id);
    }

}

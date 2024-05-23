package br.com.tamboril.services;

import br.com.tamboril.domain.product.Product;
import br.com.tamboril.domain.product.ProductResponseDTO;
import br.com.tamboril.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductResponseDTO> getAllProductsDTO() {
        List<ProductResponseDTO> responseList = new ArrayList<>();
        var productData = repository.findAll();
        productData.forEach(data -> {
            ProductResponseDTO product = new ProductResponseDTO(
                    data.getId(),
                    data.getProductName(),
                    data.getDescription(),
                    data.getPriceInCents(),
                    data.getQuantity(),
                    data.getCategory().getCategoryName(),
                    data.getBrand().getBrandName());
            responseList.add(product);
        });
        return responseList;
    }

    public ProductResponseDTO getProductDTOById(Long id) {
        var productData = repository.findById(id);
        if (productData.isPresent()) {
            Product product = productData.get();
            ProductResponseDTO productResponse = new ProductResponseDTO(
                    product.getId(),
                    product.getProductName(),
                    product.getDescription(),
                    product.getPriceInCents(),
                    product.getQuantity(),
                    product.getCategory().getCategoryName(),
                    product.getBrand().getBrandName());
            return productResponse;
        }
        return null;
    }

    public Product getProductEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

}

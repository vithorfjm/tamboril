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

    public List<ProductResponseDTO> getProducts() {
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

    public ProductResponseDTO getProductById(Long id) {
        var productData = repository.findById(id);
        if (productData.isPresent()) {
            ProductResponseDTO productResponse = new ProductResponseDTO(
                    productData.get().getId(),
                    productData.get().getProductName(),
                    productData.get().getDescription(),
                    productData.get().getPriceInCents(),
                    productData.get().getQuantity(),
                    productData.get().getCategory().getCategoryName(),
                    productData.get().getBrand().getBrandName());
            return productResponse;
        }
        return null;
    }

    public List<Product> getAllProductsById(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public Integer getTotalAmount(List<Product> products) {
        return products.stream().mapToInt(product -> product.getPriceInCents()).sum();
    }
}

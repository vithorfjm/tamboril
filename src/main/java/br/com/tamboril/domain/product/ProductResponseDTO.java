package br.com.tamboril.domain.product;

public record ProductResponseDTO(Long id,
                                 String name,
                                 String description,
                                 Integer priceInCents,
                                 Integer quantity,
                                 String category,
                                 String brand) {
}

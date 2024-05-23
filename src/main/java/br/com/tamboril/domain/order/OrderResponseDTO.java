package br.com.tamboril.domain.order;

import java.time.LocalDateTime;

public record OrderResponseDTO(Long id, LocalDateTime orderDate, String status, Integer totalAmountInCents, Integer totalItems) {
}

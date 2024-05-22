package br.com.tamboril.domain.order;

import java.util.List;

public record OrderRequestDTO(List<Long> productIds) {
}

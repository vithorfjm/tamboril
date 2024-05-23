package br.com.tamboril.domain.order;

import br.com.tamboril.domain.order_products.OrderItemDTO;

import java.util.List;

public record OrderRequestDTO(List<OrderItemDTO> items) {
}

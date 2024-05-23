package br.com.tamboril.controllers;

import br.com.tamboril.domain.order.Order;
import br.com.tamboril.domain.order.OrderRequestDTO;
import br.com.tamboril.domain.order.OrderResponseDTO;
import br.com.tamboril.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO createdOrder = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

}

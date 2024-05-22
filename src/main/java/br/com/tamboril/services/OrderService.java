package br.com.tamboril.services;

import br.com.tamboril.domain.order.Order;
import br.com.tamboril.domain.order.OrderRequestDTO;
import br.com.tamboril.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public void createOrder(OrderRequestDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Em coleta");
        order.setTotalItems(orderDTO.productIds().toArray().length);
        order.setProducts(productService.getAllProductsById(orderDTO.productIds()));
        order.setTotalAmountInCents(productService.getTotalAmount(order.getProducts()));
        orderRepository.save(order);
    }

}

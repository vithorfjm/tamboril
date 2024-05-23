package br.com.tamboril.services;

import br.com.tamboril.domain.order.Order;
import br.com.tamboril.domain.order.OrderRequestDTO;
import br.com.tamboril.domain.order.OrderResponseDTO;
import br.com.tamboril.domain.order_products.OrderItemDTO;
import br.com.tamboril.domain.order_products.OrderProducts;
import br.com.tamboril.domain.product.Product;
import br.com.tamboril.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public OrderResponseDTO createOrder(OrderRequestDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Em coleta");

        int totalQuantity = 0;
        int totalAmount = 0;

        for (OrderItemDTO itemDTO : orderDTO.items()) {
            Product product = productService.getProductEntityById(itemDTO.productId());

            OrderProducts orderProducts = new OrderProducts();
            orderProducts.setOrder(order);
            orderProducts.setProduct(product);
            orderProducts.setQuantity(itemDTO.quantity());
            order.getOrderProducts().add(orderProducts);

            totalQuantity += itemDTO.quantity();
            totalAmount += product.getPriceInCents() * itemDTO.quantity();
        }
        order.setTotalAmountInCents(totalAmount);
        order.setTotalItems(totalQuantity);
        orderRepository.save(order);

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO(
                order.getId(),
                order.getOrderDate(),
                order.getStatus(),
                order.getTotalAmountInCents(),
                order.getTotalItems());
        return orderResponseDTO;
    }

}

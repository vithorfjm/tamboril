package br.com.tamboril.repositories;

import br.com.tamboril.domain.order_products.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {
}

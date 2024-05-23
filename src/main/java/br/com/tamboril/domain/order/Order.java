package br.com.tamboril.domain.order;

import br.com.tamboril.domain.order_products.OrderProducts;
import br.com.tamboril.domain.product.Product;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    private String status;

    private Integer totalAmountInCents;

    private Integer totalItems;

    @OneToMany(mappedBy = "order")
    private List<OrderProducts> orderProducts = new ArrayList<>();

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalAmountInCents() {
        return totalAmountInCents;
    }

    public void setTotalAmountInCents(Integer totalAmountInCents) {
        this.totalAmountInCents = totalAmountInCents;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }
}

package order.book.management.service;

import java.util.List;
import order.book.management.model.Order;

public interface OrderService {
    void save(String order);

    List<Order> getAll();
}

package order.book.management.dao;

import java.util.List;
import order.book.management.model.Order;

public interface OrderDao {
    boolean add(Order order);

    List<Order> getAll();
}

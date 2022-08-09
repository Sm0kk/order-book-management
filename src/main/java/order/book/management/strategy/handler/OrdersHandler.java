package order.book.management.strategy.handler;

import java.util.List;
import order.book.management.model.Order;

public interface OrdersHandler {
    void processMarketOrder(List<Order> orders, String query);
}

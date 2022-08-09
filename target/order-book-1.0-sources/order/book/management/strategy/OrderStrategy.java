package order.book.management.strategy;

import order.book.management.strategy.handler.OrdersHandler;

public interface OrderStrategy {
    OrdersHandler get(String orderType);
}

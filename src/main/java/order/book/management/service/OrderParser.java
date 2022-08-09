package order.book.management.service;

import order.book.management.model.Order;

public interface OrderParser {
    Order getOrder(String data);
}

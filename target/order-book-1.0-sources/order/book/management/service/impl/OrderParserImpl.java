package order.book.management.service.impl;

import order.book.management.model.Order;
import order.book.management.service.OrderParser;

public class OrderParserImpl implements OrderParser {
    private static final int PRICE = 1;
    private static final int SIZE = 2;
    private static final int TYPE = 3;

    @Override
    public Order getOrder(String data) {
        String[] split = data.split(",");
        Order order = new Order();
        order.setPrice(Integer.parseInt(split[PRICE]));
        order.setSize(Integer.parseInt(split[SIZE]));
        order.setType(Order.OrderType.valueOf(split[TYPE].toUpperCase()));
        return order;
    }
}

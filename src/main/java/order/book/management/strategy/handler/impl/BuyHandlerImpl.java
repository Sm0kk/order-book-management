package order.book.management.strategy.handler.impl;

import java.util.Comparator;
import java.util.List;
import order.book.management.model.Order;
import order.book.management.strategy.handler.OrdersHandler;

public class BuyHandlerImpl implements OrdersHandler {
    @Override
    public void processMarketOrder(List<Order> orders, String query) {
        Order cheapestAsk = orders.stream()
                .filter(o -> o.getType().equals(Order.OrderType.ASK))
                .min(Comparator.comparingInt(Order::getPrice))
                .get();
        cheapestAsk.setSize(cheapestAsk.getSize() - getSize(query));
        orders.set(orders.lastIndexOf(cheapestAsk), cheapestAsk);
    }

    private int getSize(String query) {
        return Integer.parseInt(query.split(",")[2]);
    }
}

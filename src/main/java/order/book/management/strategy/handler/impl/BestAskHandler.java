package order.book.management.strategy.handler.impl;

import java.util.Comparator;
import java.util.List;
import order.book.management.model.Order;
import order.book.management.strategy.handler.QueriesHandler;

public class BestAskHandler implements QueriesHandler {
    @Override
    public String getQueryResult(List<Order> orders, String query) {
        Order bestAskOrder = orders.stream()
                .filter(o -> o.getType().equals(Order.OrderType.ASK))
                .max(Comparator.comparingInt(Order::getPrice))
                .get();
        return bestAskOrder.getPrice() + "," + bestAskOrder.getSize() + System.lineSeparator();
    }
}

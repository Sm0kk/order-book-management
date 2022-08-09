package order.book.management.strategy.handler.impl;

import java.util.Comparator;
import java.util.List;
import order.book.management.model.Order;
import order.book.management.strategy.handler.QueriesHandler;

public class BestBidHandler implements QueriesHandler {

    @Override
    public String getQueryResult(List<Order> orders, String query) {
        Order bestBidOrder = orders.stream()
                .filter(o -> o.getType().equals(Order.OrderType.BID))
                .max(Comparator.comparingInt(Order::getPrice))
                .get();
        return bestBidOrder.getPrice() + "," + bestBidOrder.getSize() + System.lineSeparator();
    }
}

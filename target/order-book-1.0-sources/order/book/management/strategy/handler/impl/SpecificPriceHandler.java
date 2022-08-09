package order.book.management.strategy.handler.impl;

import java.util.List;
import java.util.stream.Collectors;
import order.book.management.model.Order;
import order.book.management.strategy.handler.QueriesHandler;

public class SpecificPriceHandler implements QueriesHandler {
    @Override
    public String getQueryResult(List<Order> orders, String query) {
        return orders.stream().filter(o -> o.getPrice() == getPrice(query))
                .map(Order::getSize)
                .map(o -> o + "")
                .collect(Collectors.joining());
    }

    private int getPrice(String query) {
        return Integer.parseInt(query.split(",")[2]);
    }
}

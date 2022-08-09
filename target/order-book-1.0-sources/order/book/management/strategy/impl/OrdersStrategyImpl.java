package order.book.management.strategy.impl;

import java.util.Map;
import order.book.management.strategy.OrderStrategy;
import order.book.management.strategy.handler.OrdersHandler;

public class OrdersStrategyImpl implements OrderStrategy {
    private final Map<String, OrdersHandler> ordersHandlerMap;

    public OrdersStrategyImpl(Map<String, OrdersHandler> ordersHandlerMap) {
        this.ordersHandlerMap = ordersHandlerMap;
    }

    public OrdersHandler get(String queryType) {
        return ordersHandlerMap.get(queryType);
    }
}

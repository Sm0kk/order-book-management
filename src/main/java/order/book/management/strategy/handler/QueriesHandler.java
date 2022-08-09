package order.book.management.strategy.handler;

import java.util.List;
import order.book.management.model.Order;

public interface QueriesHandler {
    String getQueryResult(List<Order> orders, String query);
}

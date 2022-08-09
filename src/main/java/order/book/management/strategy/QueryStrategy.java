package order.book.management.strategy;

import order.book.management.strategy.handler.QueriesHandler;

public interface QueryStrategy {
    QueriesHandler get(String queryType);
}

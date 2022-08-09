package order.book.management.strategy.impl;

import java.util.Map;
import order.book.management.strategy.QueryStrategy;
import order.book.management.strategy.handler.QueriesHandler;

public class QueryStrategyImpl implements QueryStrategy {
    private final Map<String, QueriesHandler> queriesHandlerMap;

    public QueryStrategyImpl(Map<String, QueriesHandler> queriesHandlerMap) {
        this.queriesHandlerMap = queriesHandlerMap;
    }

    @Override
    public QueriesHandler get(String queryType) {
        return queriesHandlerMap.get(queryType);
    }
}

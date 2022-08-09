package order.book.management.strategy.handler.impl;

import java.util.List;
import order.book.management.service.OrderService;
import order.book.management.strategy.OrderStrategy;
import order.book.management.strategy.QueryStrategy;
import order.book.management.strategy.handler.ReportHandler;

public class ReportHandlerImpl implements ReportHandler {
    private static final String UPDATE = "u";
    private static final String QUERY = "q";
    private static final String ORDER = "o";
    private final OrderService orderService;
    private final QueryStrategy queryStrategy;
    private final OrderStrategy orderStrategy;

    public ReportHandlerImpl(OrderService orderService,
                             QueryStrategy queryStrategy,
                             OrderStrategy orderStrategy) {
        this.orderService = orderService;
        this.queryStrategy = queryStrategy;
        this.orderStrategy = orderStrategy;
    }

    @Override
    public String getOutputData(List<String> data) {
        StringBuilder report = new StringBuilder();
        for (String datum : data) {
            if (datum.startsWith(UPDATE)) {
                orderService.save(datum);
            }
            if (datum.startsWith(QUERY)) {
                report.append(queryStrategy.get(datum.split(",")[1])
                        .getQueryResult(orderService.getAll(), datum));
            }
            if (datum.startsWith(ORDER)) {
                orderStrategy.get(datum.split(",")[1])
                        .processMarketOrder(orderService.getAll(), datum);
            }
        }
        return report.toString();
    }

}

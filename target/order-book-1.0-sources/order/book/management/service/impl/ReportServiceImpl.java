package order.book.management.service.impl;

import java.util.List;
import order.book.management.service.OrderService;
import order.book.management.service.ReportService;
import order.book.management.strategy.OrderStrategy;
import order.book.management.strategy.QueryStrategy;

public class ReportServiceImpl implements ReportService {
    private static final String UPDATE = "u";
    private static final String QUERY = "q";
    private static final String ORDER = "o";
    private final OrderService orderService;
    private final QueryStrategy queryStrategy;
    private final OrderStrategy orderStrategy;

    public ReportServiceImpl(OrderService orderService,
                             QueryStrategy queryStrategy,
                             OrderStrategy orderStrategy) {
        this.orderService = orderService;
        this.queryStrategy = queryStrategy;
        this.orderStrategy = orderStrategy;
    }

    @Override
    public String getOutputData(List<String> data) {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).startsWith(UPDATE)) {
                orderService.save(data.get(i));
            }
            if (data.get(i).startsWith(QUERY)) {
                report.append(queryStrategy.get(data.get(i).split(",")[1])
                                .getQueryResult(orderService.getAll(), data.get(i)));
            }
            if (data.get(i).startsWith(ORDER)) {
                orderStrategy.get(data.get(i).split(",")[1])
                                .processMarketOrder(orderService.getAll(), data.get(i));
            }
        }
        return report.toString();
    }
}

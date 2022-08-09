package order.book.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import order.book.management.dao.OrderDao;
import order.book.management.dao.impl.OrderDaoImpl;
import order.book.management.service.OrderParser;
import order.book.management.service.OrderService;
import order.book.management.service.ReaderService;
import order.book.management.service.WriterService;
import order.book.management.service.impl.OrderParserImpl;
import order.book.management.service.impl.OrderServiceImpl;
import order.book.management.service.impl.ReaderServiceImpl;
import order.book.management.service.impl.WriterServiceImpl;
import order.book.management.strategy.OrderStrategy;
import order.book.management.strategy.QueryStrategy;
import order.book.management.strategy.handler.OrdersHandler;
import order.book.management.strategy.handler.QueriesHandler;
import order.book.management.strategy.handler.ReportHandler;
import order.book.management.strategy.handler.impl.BestAskHandler;
import order.book.management.strategy.handler.impl.BestBidHandler;
import order.book.management.strategy.handler.impl.BuyHandlerImpl;
import order.book.management.strategy.handler.impl.ReportHandlerImpl;
import order.book.management.strategy.handler.impl.SellHandlerImpl;
import order.book.management.strategy.handler.impl.SpecificPriceHandler;
import order.book.management.strategy.impl.OrdersStrategyImpl;
import order.book.management.strategy.impl.QueryStrategyImpl;

public class Main {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) {
        Map<String, QueriesHandler> queriesHandlerMap = new HashMap<>();
        queriesHandlerMap.put("best_bid", new BestBidHandler());
        queriesHandlerMap.put("best_ask", new BestAskHandler());
        queriesHandlerMap.put("size", new SpecificPriceHandler());

        Map<String, OrdersHandler> ordersHandlerMap = new HashMap<>();
        ordersHandlerMap.put("buy", new BuyHandlerImpl());
        ordersHandlerMap.put("sell", new SellHandlerImpl());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(INPUT_FILE);

        OrderDao orderDao = new OrderDaoImpl();
        OrderParser orderParser = new OrderParserImpl();
        OrderService orderService = new OrderServiceImpl(orderDao, orderParser);
        QueryStrategy queryStrategy = new QueryStrategyImpl(queriesHandlerMap);
        OrderStrategy orderStrategy = new OrdersStrategyImpl(ordersHandlerMap);
        ReportHandler reportHandler = new ReportHandlerImpl(orderService,
                queryStrategy, orderStrategy);

        String report = reportHandler.getOutputData(dataFromFile);

        WriterService writerService = new WriterServiceImpl();
        writerService.write(report, OUTPUT_FILE);
    }
}

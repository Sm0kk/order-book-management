package order.book.management.service.impl;

import java.util.List;
import order.book.management.dao.OrderDao;
import order.book.management.model.Order;
import order.book.management.service.OrderParser;
import order.book.management.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final OrderParser orderParser;

    public OrderServiceImpl(OrderDao orderDao, OrderParser orderParser) {
        this.orderDao = orderDao;
        this.orderParser = orderParser;
    }

    @Override
    public void save(String order) {
        orderDao.add(orderParser.getOrder(order));
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }
}

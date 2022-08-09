package order.book.management.dao.impl;

import java.util.ArrayList;
import java.util.List;
import order.book.management.dao.OrderDao;
import order.book.management.db.Storage;
import order.book.management.model.Order;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean add(Order order) {
        return Storage.orders.add(order);
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(Storage.orders);
    }
}

package order.book.management.model;

import java.util.Objects;

public class Order {
    private int price;
    private int size;
    private OrderType type;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return price == order.price && size == order.size && type == order.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, size, type);
    }

    public enum OrderType {
        ASK("aks"),
        BID("bid"),
        SPREAD("spread");

        private String type;

        OrderType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}

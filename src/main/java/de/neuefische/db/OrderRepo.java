package de.neuefische.db;

import de.neuefische.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<String, Order> orders = new HashMap<>();

    public OrderRepo(List<Order> orders) {
        addOrders(orders);
    }

    public OrderRepo(){
    }

    public List<Order> listOrders(){
        return List.copyOf(orders.values());
        // List.copyOf: unmodifiable List to protect orders from the outside (new ArrayList would be modifiable)
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public Order addOrder(Order order){
        if (this.orders.containsKey(order.getId())) {
            throw new RuntimeException("Cannot place order; order with id " + order.getId() + " already exists.");
        }
        orders.put(order.getId(), order);
        return order;
    }

    // not necessarily needed: possibility to input list of orders
    public void addOrders(List<Order> orders) {
        for (Order order : orders) {
            addOrder(order);
        }
    }

}



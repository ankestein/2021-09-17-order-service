package de.neuefische.db;

import de.neuefische.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<Integer, Order> orders = new HashMap<>();


    public OrderRepo(List<Order> orders) {
        addOrders(orders);
    }

    public OrderRepo(){
    }

    public List<Order> listOrders(){
        return new ArrayList<>(orders.values());
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public void addOrders(Order order){
        if (this.orders.containsKey(order.getId())) {
            throw new RuntimeException("Cannot place order; order with id " + order.getId() + " already exists.");
        }
        orders.put(order.getId(), order);
    }

    public void addOrders(List<Order> orders) {
        for (Order order : orders) {
            addOrders(order);
        }
    }

}



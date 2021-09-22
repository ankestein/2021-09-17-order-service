package de.neuefische.db;

import de.neuefische.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {
    private Map<Integer, Order> orders = new HashMap<>();

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


}



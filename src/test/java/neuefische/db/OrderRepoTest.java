package de.neuefische.db;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {
    @Test
    @DisplayName("listOrders() should return a list of all orders")
    public void testListOrders(){
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product (111, "bookA"), new Product(21, "bookB"))));
        Order order2 = new Order(2, new ArrayList<Product>(List.of(new Product(222, "pencil"))));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        List<Order> actual = orderRepo.listOrders();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1, order2));
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("listOrders() of an empty OrderRepo should return null")
    public void testListZeroOrders(){
        // given
        OrderRepo orderRepo = new OrderRepo();
        // when
        List<Order> actual = orderRepo.listOrders();
        // then
        List<Order> expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getOrder() should return order with the given id")
    public void testGetOrder(){
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product (111, "bookA"), new Product(21, "bookB"))));
        Order order2 = new Order(2, new ArrayList<Product>(List.of(new Product(222, "pencil"))));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        Order actual = orderRepo.getOrder(2);
        // then
        Order expected = order2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getOrder() should return null if no order with matching id exists")
    public void testGetNonExistingOrder(){
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product (111, "bookA"), new Product(21, "bookB"))));
        Order order2 = new Order(2, new ArrayList<Product>(List.of(new Product(222, "pencil"))));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        Order actual = orderRepo.getOrder(3);
        // then
        Order expected = null;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addOrders() should add an order to OrderRepo")
    public void testAddOrder(){
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product (111, "bookA"), new Product(21, "bookB"))));
        Order order2 = new Order(2, new ArrayList<Product>(List.of(new Product(222, "pencil"))));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        Order order3 = new Order(3, new ArrayList<Product>(List.of(new Product(333, "computer"))));
        // when
        orderRepo.addOrders(order3);
        List<Order> actual = orderRepo.listOrders();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1, order2, order3));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addOrders() used on an empty OrderRepo should add an order")
    public void testAddFirstOrder(){
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product (111, "bookA"), new Product(21, "bookB"))));
        OrderRepo orderRepo = new OrderRepo();
        // when
        orderRepo.addOrders(order1);
        List<Order> actual = orderRepo.listOrders();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1));
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("addOrder() with an already existing id should throw an exception")
    public void testAddOrderWithSameIdException() {
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product (111, "bookA"), new Product(21, "bookB"))));
        Order order2 = new Order(2, new ArrayList<Product>(List.of(new Product(222, "pencil"))));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        // when
        try {
            orderRepo.addOrders(new Order(2, new ArrayList<Product>(List.of(new Product(222, "stapler")))));    fail("Exception not thrown!");
        } catch (RuntimeException e) {
            String actual = e.getMessage();
            String expected = "Cannot place order; order with id 2 already exists.";
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("addOrder() with a list input should add multiple orders to an OrderRepo")
    public void testAddOrderList(){
        // given
        Order order1 = new Order(1, new ArrayList<Product>(List.of(new Product(111, "bookA"), new Product(21, "bookB"))));
        Order order2 = new Order(2, new ArrayList<Product>(List.of(new Product(222, "pencil"))));
        OrderRepo orderRepo = new OrderRepo(List.of(order1, order2));
        Order order3 = new Order(3, new ArrayList<Product>(List.of(new Product(333, "computer"))));
        Order order4 = new Order(4, new ArrayList<Product>(List.of(new Product(111, "bookA"), new Product(115, "keyboard"))));   List<Order> newOrders = new ArrayList<>(List.of(order3, order4));
        // when
        orderRepo.addOrders(newOrders);
        List<Order> actual = orderRepo.listOrders();
        // then
        List<Order> expected = new ArrayList<>(List.of(order1, order2, order3, order4));
        Assertions.assertEquals(expected, actual);
    }

}
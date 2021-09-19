package de.neuefische.service;

import de.neuefische.db.OrderRepo;
import de.neuefische.db.ProductRepo;
import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public Product getProduct(int id) {
        return productRepo.getProductById(id);
    }

    public List<Product> listProducts() {
        return productRepo.listProducts();
    }


    public void addOrder(int orderId, List<Integer> productIds) {
        ProductRepo productsToOrder = new ProductRepo();
        for (int productId : productIds) {
            Product product = getProductById(productId);
            if (product == null) {
                throw new RuntimeException("Product with id " + productId + " does not exist.");
            }
            productsToOrder.addProduct(product);
        }
        orderRepo.addOrders(new List<Order>(orderId, productsToOrder));
    }


    public Order getOrder(int id) {
        return orderRepo.getOrder(id);
    }

    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }


}

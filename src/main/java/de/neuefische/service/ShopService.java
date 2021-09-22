package de.neuefische.service;

import de.neuefische.db.OrderRepo;
import de.neuefische.db.ProductRepo;
import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {

    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    private Product getProduct(int productId){
        Optional<Product> optionalProduct = productRepo.getProductById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new IllegalArgumentException("Product with ID " + productId + " not found");
        }
    }

    public List<Product> listProducts() {
        return productRepo.listProducts();
    }


    public Order addOrder(List<String> productIds) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        String id = UUID.randomUUID().toString();
        return orderRepo.addOrder(new Order(id, productsToOrder));
    }


    public Order getOrder(int id) {
        return orderRepo.getOrder(id);
    }

    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }


}

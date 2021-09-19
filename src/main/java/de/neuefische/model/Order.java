package de.neuefische.model;

import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private List<Product> products;

    public Order(int id, List<Product> products){
        this.id = id;
        this.products = products;
    }

    public int getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }
}
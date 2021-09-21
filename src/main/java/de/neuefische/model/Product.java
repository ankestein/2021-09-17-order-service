package de.neuefische.model;

import java.util.Objects;

public class Product {

    private int id;
    private String name;

    // constructor
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    // equals and hash code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

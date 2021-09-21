package de.neuefische.db;

import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductRepo {

    private List<Product> products;

    // constructors
    public ProductRepo(List<Product> products) {
        this.products = Collections.unmodifiableList(products);
        // new ArrayList() would be modifiable, but we want to protect list from being modified from the outside.
        // List() is also unmodifiable, but "new List()" produces error "'List' is abstract, cannot be instantiated"
    }

    public ProductRepo() {
    }

    public List<Product> listProducts() {
        return products;
    }

    public Optional<Product> getProductById(int id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return null;
    }

    // to do: add test for addProduct()
    public void addProduct(Product product) {
        products.add(product);
    }
}

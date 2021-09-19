package de.neuefische.db;

import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    private List<Product> products;

    // constructors
    public ProductRepo(List<Product> products){
        this.products = new ArrayList<>(products);
    }

    public ProductRepo(){
    };


    public List<Product> listProducts(){
        return products;
    }

    public Product getProductById(int id){
        for (Product product : products){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}

package neuefische.db;

import de.neuefische.db.ProductRepo;
import de.neuefische.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepoTest {

    @Test
    @DisplayName("listProducts() should return a list of all products")
    public void testListProducts() {
        // given
        List<Product> products = List.of(
                new Product(1, "keyboard"),
                new Product(2, "stapler"),
                new Product(3, "pencil")
        );
        ProductRepo productRepo = new ProductRepo(products);

        // when
        List<Product> actual = productRepo.listProducts();

        // then
        List<Product> expected = products;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("listProducts() of an empty ProductRepo should return null")
    public void testListEmptyListOfProducts() {
        // given
        ProductRepo productRepo = new ProductRepo();

        // when
        List<Product> actual = productRepo.listProducts();

        // then
        Assertions.assertNull(actual);
    }

    @Test
    @DisplayName("getProductById should return product with the given id")
    public void testGetProductById() {
        // given
        List<Product> products = List.of(
                new Product(1, "keyboard"),
                new Product(2, "stapler"),
                new Product(3, "pencil")
        );
        ProductRepo productRepo = new ProductRepo(products);

        // when
        Optional<Product> actual = productRepo.getProductById(2);

        // then
        Assertions.assertEquals(new Product(2, "stapler"), actual);
    }


    @Test
    @DisplayName("getProductById should return null if product with the given id does not exist")
    public void testGetNonExistingProductById() {
        // given
        List<Product> products = List.of(
                new Product(1, "keyboard"),
                new Product(2, "stapler"),
                new Product(3, "pencil")
        );
        ProductRepo productRepo = new ProductRepo(products);

        // when
        Optional<Product> actual = productRepo.getProductById(4);

        // then
        Assertions.assertNull(actual);
    }



}

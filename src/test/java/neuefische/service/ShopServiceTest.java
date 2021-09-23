package neuefische.service;

import de.neuefische.db.OrderRepo;
import de.neuefische.db.ProductRepo;
import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.service.ShopService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ShopServiceTest {

    @Test
    @DisplayName("addOrder() should add an order with given id and products to an OrderRepo")
    public void testAddOrder(){
       //GIVEN
        List<Product> products = List.of(
                new Product(1, "piano"),
                new Product(2, "guitar"),
                new Product(3, "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //WHEN
        Order actual = shopService.addOrder(List.of(1, 3));

        //THEN
        List<Product> expected = List.of(
                new Product(1, "piano"),
                new Product(3, "drums")
        );
        assertEquals(expected, actual.getProducts());
}

/*
    @Test
    @DisplayName("addOrder() with an already existing id should throw an exception")
    public void testAddOrderWithSameIdException(){
        // given

        // when

        // then
    }
*/


    @Test
    @DisplayName("addOrder() with non-existing productId should throw an exception")
    public void testAddOrderNonExistingProduct() {
        //GIVEN
        List<Product> products = List.of(
                new Product(1, "piano"),
                new Product(2, "guitar"),
                new Product(3, "drums")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        try {
            //WHEN
            shopService.addOrder(List.of(1, 4));
            fail("Exception not thrown!");
        } catch (IllegalArgumentException actual) {
            //THEN
            assertEquals("Product with ID 4 not found", actual.getMessage());
        }
    }


}
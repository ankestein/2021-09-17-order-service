package neuefische.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShopServiceTest {

    @Test
    @DisplayName("addOrder() should add an order with given id and products to an OrderRepo")
    public void testAddOrder(){
        // given

        // when

        // then
    }

}

    @Test
    @DisplayName("addOrder() used on an empty OrderRepo should add an order with given id and products")
    public void testAddFirstOrder(){
        // given

        // when

        // then
    }


    @Test
    @DisplayName("addOrder() with an already existing id should throw an exception")
    public void testAddOrderWithSameIdException(){
        // given

        // when

        // then
    }



    @Test
    @DisplayName("addOrder() with non-existing productId should throw an exception")
    public void testAddOrderWithNonExistingProductIdException(){
        // given

        // when

        // then
    }

}
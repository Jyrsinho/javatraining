package TakeOut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ShoppingBagTest {

    ShoppingBag<PricedItem<Number>> shoppingBag;
    Food sandwich = new Food("sandwich", "new sandwich", 5);
    Food sausage = new Food("sausage", "new sausage", 2);

    @BeforeEach
    public void setUp(){
        shoppingBag = new ShoppingBag<>();

    }

    @Test
    public void testShouldAddNewItemToShoppingBag() {
        assertEquals(0, shoppingBag.getTheAmountOfItems());
        shoppingBag.addItem(sandwich);
        shoppingBag.addItem(sandwich);
        assertEquals(1, shoppingBag.getTheAmountOfItems());
        shoppingBag.addItem(sausage);
        assertEquals(2, shoppingBag.getTheAmountOfItems());

    }

    @Test
    public void testEmptyShoppingBagShouldReturnTotalPriceOfZero() {
        assertEquals(0, shoppingBag.getTotalPrice());
    }


    @Test
    public void testShouldReturnTheTotalPriceOf10ForTwoSausages(){
        shoppingBag.addItem(sausage);
        shoppingBag.addItem(sausage);
        assertEquals(4, shoppingBag.getTotalPrice());

    }

    @Test
    public void testShouldReturnTheTotalPriceOf10ForTwoSandwiches(){
        shoppingBag.addItem(sandwich);
        shoppingBag.addItem(sandwich);
        assertEquals(10, shoppingBag.getTotalPrice());

    }

    @Test
    public void testShouldReturnTheTotalPriceOf14ForTwoSandwichesAndTwoSausages(){
        shoppingBag.addItem(sandwich);
        shoppingBag.addItem(sandwich);
        shoppingBag.addItem(sausage);
        shoppingBag.addItem(sausage);
        assertEquals(14, shoppingBag.getTotalPrice());

    }
}

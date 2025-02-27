package CompositeTest;


import DesignPatterns.Composite.Box;
import DesignPatterns.Composite.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompositeTest {

    @Test
    public void testShouldAddProductsToABox() {
        Box box = new Box();
        Product product = new Product(5, "Lelu");

        box.add(product);
        assertEquals(1, box.amountOfItems());
    }

    @Test
    public void testShouldReturThePriceOfBoxWithTwoProducts() {
        Box box = new Box();
        Product product1 = new Product(5, "Lelu");
        Product product2 = new Product(6, "Lelu");
        box.add(product1);
        box.add(product2);

        assertEquals(11, box.getPrice());
    }

    @Test
    public void testShouldReturnThePriceOfBoxWithTwoBoxesWithTwoProducts() {
        Box mainBox = new Box();
        Box childBox1 = new Box();
        Box childBox2 = new Box();

        Product product1 = new Product(5, "Lelu");
        Product product2 = new Product(6, "Lelu3");
        childBox1.add(product1);
        childBox1.add(product2);

        Product product3 = new Product(7, "Lelu");
        Product product4 = new Product(8, "Lelu");
        childBox2.add(product3);
        childBox2.add(product4);

        mainBox.add(childBox1);
        mainBox.add(childBox2);

        assertEquals(26, mainBox.getPrice());


    }
}

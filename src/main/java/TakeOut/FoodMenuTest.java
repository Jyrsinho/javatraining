package TakeOut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FoodMenuTest {

    FoodMenu menu;
    @BeforeEach
    public void setUp(){
        menu = new FoodMenu();
    }
    @Test
    public void testShouldReturnTheFoodItemFromTheMenuFromTheGivenIndex() {
        Food food = menu.getFood(1);
        assertEquals("sandwich", food.getName());
        assertEquals("new sandwich", food.getDescription());
        assertEquals(5, food.getPrice());
    }

    @Test
    public void testShouldThrowNullPointerExceptionWhenAskedIndexThatIsHigherOrLowerThanTheAmountOfObjectsInTheMenu() {

        IndexOutOfBoundsException exception1 = assertThrows(IndexOutOfBoundsException.class, ()->
        {menu.getFood(0);});
        assertEquals("Index 0 out of bounds for length 3", exception1.getMessage());

        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, ()->
        {menu.getFood(4);});
        assertEquals("Index 4 out of bounds for length 3", exception2.getMessage());
    }

    @Test
    public void testShouldReturnSausageWhenAskingForLowestCostFood() {
        assertEquals("sausage", menu.getLowestCostFood().getName());
    }



}

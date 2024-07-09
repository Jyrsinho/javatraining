package TakeOut;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu() {
        this.menu = new ArrayList<>();
        menu.add(new Food("sandwich", "new sandwich", 5));
        menu.add(new Food("sausage", "new sausage", 2));
        menu.add(new Food("pizza", "new pizza", 10));
    }


    /**
     * returns the food item from the menu from the given index
     * @param index of the food item
     * @return the food item from the menu from the given index
     */
    public Food getFood(int index) {
        if (index < 1 || index > menu.size()) {
            throw new IndexOutOfBoundsException(STR."Index \{index} out of bounds for length \{menu.size()}");
        }
        return menu.get(index-1);
    }

    /**
     * returns the food item with the lowest cost
     * @return the food item with the lowest cost
     */
    public Food getLowestCostFood() {
        int lowestCostFoodIndex = 0;
        int lowestCostFoodPrice = (int) menu.getFirst().getPrice();

        for (int i = 0; i < menu.size(); i++) {
            int comparableFoodPrice = (int) menu.get(i).getPrice();
            if (comparableFoodPrice < lowestCostFoodPrice) {
                lowestCostFoodIndex = comparableFoodPrice;
                lowestCostFoodIndex = i;
            }
        }

        return menu.get(lowestCostFoodIndex);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (Food food : menu) {
            sb.append(index++).append(". ");
            sb.append(food.toString()).append("\n");
        }
        return sb.toString();
    }


    /**
     * test method for FoodMenu
     * @param args not used
     */
    public static void main(String [] args) {
        FoodMenu menu = new FoodMenu();
        System.out.println(menu);
    }
}

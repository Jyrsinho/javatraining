package TakeOut;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem<Number>>{
    private Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        this.shoppingBag = new HashMap<>();
    }


    /**
     * Adds key-value pairs of food items and their amounts in the shoppingBag
     * @param item to be added to the shopping bag
     */
    public void addItem(T item) {
        if (shoppingBag.containsKey(item)) {
            int newAmount = shoppingBag.get(item);
            newAmount++;
            shoppingBag.put(item, newAmount);
            //jos sisältää jo itemin. Lisää itemin arvoa yhdellä.
        }
        else {
            shoppingBag.put(item,1);
            // lisää uusi key-value pari mappiin
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<T, Integer> entry: shoppingBag.entrySet()) {
            T key = entry.getKey();
            int value = entry.getValue();
            totalPrice += key.getPrice().intValue() * value;
        }
        return totalPrice;
    }


    public int getTheAmountOfItems() {
        return shoppingBag.size();
    }
}

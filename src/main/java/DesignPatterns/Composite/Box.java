package DesignPatterns.Composite;

import java.util.ArrayList;

public class Box implements Composite {

    ArrayList<Composite> products;

    public Box() {
        products = new ArrayList<>();
    }

    public int amountOfItems() {
        return products.size();
    }

    @Override
    public double getPrice() {
        double totalPrice = 0.0;
        for (Composite product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void add(Composite composite) {
        products.add(composite);
    }

    @Override
    public void remove(Composite composite) {
        products.remove(composite);
    }


}

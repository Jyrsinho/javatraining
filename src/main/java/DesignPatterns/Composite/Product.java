package DesignPatterns.Composite;

public class Product implements Composite{

    double price;
    String name;

    public Product(double price, String name) {

        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void add(Composite composite) {
        throw new UnsupportedOperationException("Cannot add to a Product");
    }

    @Override
    public void remove(Composite composite) {
        throw new UnsupportedOperationException("Cannot remove from a Product");
    }
}

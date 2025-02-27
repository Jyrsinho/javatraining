package DesignPatterns.Composite;

public interface Composite {

    double getPrice();
    void add(Composite composite);
    void remove(Composite composite);

}

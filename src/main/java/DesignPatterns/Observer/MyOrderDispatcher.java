package DesignPatterns.Observer;

public class MyOrderDispatcher implements MyObserver {


    @Override
    public void update(MyEvent event) {
        System.out.println("I have ordered a shipping for " + event.getName());
    }
}

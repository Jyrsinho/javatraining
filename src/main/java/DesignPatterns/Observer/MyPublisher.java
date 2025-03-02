package DesignPatterns.Observer;

import java.util.Observable;
import java.util.Observer;

public class MyPublisher implements MyObserver {


    @Override
    public void update(MyEvent event) {
        System.out.println("I have observed event " + event.name);
    }
}

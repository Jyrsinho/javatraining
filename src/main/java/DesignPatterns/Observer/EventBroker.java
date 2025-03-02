package DesignPatterns.Observer;

import java.util.HashMap;

public class EventBroker {

    HashMap<MyEvent, MyObserver> events;

    public EventBroker() {
        events = new HashMap<>();
    }


}

package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class EventBroker {

    HashMap<MyEvent, ArrayList<MyObserver>> events;

    public EventBroker() {
        events = new HashMap<>();
    }

    /**
     * Adds an observer to an event
     * @param event that gets an observer
     * @param observer that is added to an event
     */
    public void addObserver(MyEvent event, MyObserver observer) {
        // if current event is already in the system, add new observer to it.
        if (events.containsKey(event)) {
            ArrayList<MyObserver> eventListerers = events.get(event);
            eventListerers.add(observer);
        }
    }

}

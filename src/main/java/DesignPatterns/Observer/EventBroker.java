package DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventBroker {

    HashMap<MyEvent, List<MyObserver>> events;

    public EventBroker() {
        events = new HashMap<>();
    }

    public void addEvent(MyEvent event) {
        events.put(event, new ArrayList<>());
    }

    /**
     * Adds an observer to an event
     * @param event that gets an observer
     * @param observer that is added to an event
     */
    public void subscribe(MyEvent event, MyObserver observer) {
        // if current event is already in the system, add new observer to it.
        if (events.containsKey(event)) {
            List<MyObserver> eventListerers = events.get(event);
            eventListerers.add(observer);
        }
        else {
            events.put(event, new ArrayList<>());
            events.get(event).add(observer);
        }
    }

    public void notify(MyEvent event) {
        List<MyObserver> eventListerers;
        if (events.containsKey(event)) {
            eventListerers = events.get(event);
            for (int i = 0; i <eventListerers.size() ; i++) {
                eventListerers.get(i).update(event);
            }
        }
        else {
            System.out.println("Ei ollut kuuntelijoita tälle eventille");
        }
    }

}

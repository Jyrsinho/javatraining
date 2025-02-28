package DesignPatterns.EventDrivenLaskuri;

import java.util.ArrayList;

public class EventBroker {
    ArrayList<MyEventListener> eventListeners;

    public EventBroker() {
        eventListeners = new ArrayList<>();
    }

    public void addListener(MyEventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void dispatchEvent(CalculationEvent event) {
        for (MyEventListener eventListener : eventListeners) {
            eventListener.onEvent(event);
        }
    }
}

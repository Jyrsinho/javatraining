package DesignPatterns.Observer;

public class Order extends MyEvent{

    EventBroker eventBroker;
    String name;

    public Order (String name, EventBroker eventBroker){
        this.name = name;
        this. eventBroker = eventBroker;
    }

    @Override
    public void declareEvent() {
        eventBroker.notify(this);
    }

    public String getName() {
        return name;
    }

}

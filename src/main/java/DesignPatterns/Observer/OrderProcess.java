package DesignPatterns.Observer;

public class OrderProcess {


    public static void main(String[] args) {

        EventBroker eventBroker = new EventBroker();
        Order order = new Order("tilausvahvistus", eventBroker);
        MyPublisher publisher = new MyPublisher();
        MyOrderDispatcher dispatcher = new MyOrderDispatcher();
        eventBroker.subscribe(order, publisher);
        eventBroker.subscribe(order, dispatcher);

        order.declareEvent();


    }
}

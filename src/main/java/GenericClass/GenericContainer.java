package GenericClass;

import java.util.ArrayList;

public class GenericContainer<T> {

    ArrayList<T> container;

    public GenericContainer() {
        container = new ArrayList<T>();
    }

    public GenericContainer(ArrayList<T> container) {
        this.container = container;
    }
}

package GenericClass;

import java.util.ArrayList;

public class Container<T> {

    ArrayList<T> list = new ArrayList<>();

    public Container(){
        new ArrayList<T>();
    }

    public void add(T item){
        list.add(item);
    }
}

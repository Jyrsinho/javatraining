package GenericClass;

import java.util.ArrayList;

public class GenericType<Object>{
    Object data;


    public GenericType(Object data ) {
        this.data = data;
    }

    public void printValue() {

        System.out.println(data);
    }

    public void printClass() {
        System.out.println(data.getClass().getSimpleName());
    }


    public static void main(String[] args) {

        ArrayList<Integer> items = new ArrayList<>();
        items.add(2);
        items.add(1);


    }

}


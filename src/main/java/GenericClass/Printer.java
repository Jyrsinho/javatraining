package GenericClass;

import java.util.ArrayList;
import java.util.Arrays;

public class Printer<T> {

    T data;

    public Printer(T data){
        this.data = data;
    }


    public String getDataAsString() {

        System.out.println(data);

        return data.toString();
    }


    public String getDataAsClass(T data) {
        System.out.println(data.getClass());

        return data.getClass().getSimpleName();
    }


    public ArrayList<T> createOutput(T[] input) {

        ArrayList<T> outPut = new ArrayList<>(Arrays.asList(input));


        return outPut;
    }



    public static void main(String[] args) {

    }
}

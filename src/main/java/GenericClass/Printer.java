package GenericClass;

import java.util.ArrayList;
import java.util.Arrays;

public class Printer<T> {

    T data;

    public Printer(T data){
        this.data = data;
    }


    public String getDataAsString() {

        print(data);

        return data.toString();
    }


    public String getDataAsClass() {
        System.out.println(data.getClass().getSimpleName());
        print(data);
        return data.getClass().getSimpleName();
    }


    public <T> void print(T data){
        System.out.println(data);
    }


    public ArrayList<T> createOutput(T[] input) {

        ArrayList<T> outPut = new ArrayList<>(Arrays.asList(input));


        return outPut;
    }



    public static void main(String[] args) {

    }
}

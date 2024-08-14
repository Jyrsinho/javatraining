package GenericClass;

import java.util.ArrayList;

public class Printer<T> {

    ArrayList<T> dataList = new ArrayList<>();


    public Printer() {}


    public Printer( ArrayList<T> dataList){
        this.dataList = dataList;
    }

    public <T> void print(T data){
        System.out.println(data);
    }

    public void printInput ()  {

    }

}

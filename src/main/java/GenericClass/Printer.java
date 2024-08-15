package GenericClass;

public class Printer<T> {



    public Printer() {
    }


    public  void print(T data) {
        System.out.println(data.getClass().getSimpleName());
        System.out.println(data);

    }

    public static void main(String[] args) {

        Integer int1 = 1;
        Printer<Integer> Iprinter = new Printer<>();
        Iprinter.print(int1);

        String string = "Hello World";
        Printer<String> sPrinter = new Printer<>();
        sPrinter.print(string);



    }
}

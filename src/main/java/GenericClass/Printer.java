package GenericClass;

public class Printer<T> {

    private T data;
    private int amountOfValuesToPrint;

    public Printer() {}


    public String getDataAsString(T data) {

        System.out.println(data.getClass());
        System.out.println(data);

        return data.toString();
    }


    public String getDataAsClass(T data) {
        return data.getClass().getSimpleName();
    }



    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.getDataAsString("Auto");
    }
}

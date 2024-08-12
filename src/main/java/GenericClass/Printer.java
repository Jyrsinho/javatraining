package GenericClass;

public class Printer<T> {

    private T data;

    public Printer() {}

    public T print(T data) {
        this.data = data;
        System.out.println(data.getClass());
        System.out.println(data);

        return data;
    }


    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print("Auto");
    }
}

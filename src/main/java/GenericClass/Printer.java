package GenericClass;

public class Printer<T> {

    GenericContainer<T> container;


    public Printer() {}


    public Printer(GenericContainer<T> container){
        this.container= container;
    }

    /**
     * Prints the output
     * @return the amount of lines in output
     */
    public int print ()  {

        return 2;
    }

}

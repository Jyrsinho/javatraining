package DesignPatterns.Singleton;

public class Client {

    public static void main(String[] args) {

        DataObject dao = DataObject.getInstance("Heippa");
        DataObject dao2 = DataObject.getInstance("Kimmo");

        System.out.println(dao.getValue());
        System.out.println(dao2.getValue());
    }
}

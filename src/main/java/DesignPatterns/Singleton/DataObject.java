package DesignPatterns.Singleton;

public class DataObject {

    private static DataObject instance;
    private String value;

    private DataObject(String value) {
        this.value = value;
    }

    public static DataObject getInstance(String value) {
        if (instance == null) {
            instance = new DataObject(value);
            return instance;
        }
        return instance;
    }

    public String getValue() {
        return value;
    }
}

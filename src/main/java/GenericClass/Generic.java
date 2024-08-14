package GenericClass;

public class Generic<T> {

    private T value;

    public Generic(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String showType () {
        return value.getClass().getSimpleName();
    }
}

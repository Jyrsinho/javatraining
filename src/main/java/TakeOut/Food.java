package TakeOut;

public class Food implements PricedItem<Number>{

    private String name;
    private String description;
    private int price;

    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public Number getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Number price) {
        this.price = (int) price;
    }

    @Override
    public String toString(){
        return STR."\{name}: \{description}  Cost: $\{price}";
    }
}

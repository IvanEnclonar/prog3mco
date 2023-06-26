public class Item {
    private String name;
    private float price;
    private float calories;

    // Constructor
    public Item(String name, float price, float calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    // Getter Functions
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getCalories() {
        return calories;
    }
}

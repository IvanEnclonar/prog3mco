public class Item {
    private String name;
    private int price;
    private float calories;

    // Constructor
    public Item(String name, int price, float calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter Functions
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public float getCalories() {
        return calories;
    }
}
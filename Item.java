/**
 * Represents an item in the menu. It has a name, price, and calories.
 */
public class Item {
    private String name;
    private int price;
    private float calories;

    /**
     * Constructor for Item
     * 
     * @param name     Parameter for the name of the item
     * @param price    Parameter for the price of the item
     * @param calories Parameter for the calories of the item
     */
    public Item(String name, int price, float calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    /**
     * Sets the price of the item
     * 
     * @param price of the item
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Gets the name of the item
     * 
     * @return name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the item
     * 
     * @return price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the calories of the item
     * 
     * @return calories of the item
     */
    public float getCalories() {
        return calories;
    }
}
/**
 * Represents an Addon Item for a Burger.
 * Stored in Burger and extends an Item.
 */
public class Addons extends Item {
    /**
     * Creates a new add-on
     * 
     * @param name name of the add-on
     * @param price price of the add-on
     * @param calories caloric value of the add-on
     */
    public Addons(String name, int price, float calories) {
        super(name, price, calories);
    }
}

import java.util.ArrayList;

/**
 * Represents a Burger Item. This item can have addons and the addons modify the
 * price, calories, and name of the burger.
 * Stored in the Vending Machine and extends the Item Class,
 */
public class Burger extends Item {
    ArrayList<Addons> addons = new ArrayList<Addons>();
    private String name;

    /**
     * Creates a new Burger
     * 
     * @param price    price of the burger
     * @param calories caloric value of the burger
     */
    public Burger(int price, float calories) {
        super("Regular Burger", price, calories);
        this.name = "Regular Burger";
    }

    /**
     * Adds an add-on to the burger
     * 
     * @param addon add-on to be added
     */
    public void addAddons(Addons addon) {
        addons.add(addon);
    }

    /**
     * Checks if there are multiple addons of the same type
     * 
     * @return string for that addon
     */
    private String checkPlural(String name, int count) {
        if (count > 1) {
            return count + " " + name + "s";
        }
        if (count == 1) {
            return "a " + name;
        }
        else {
            return "";
        }
    }

    /**
     * Gets number of a specific addon
     * 
     * @return number of addons
     */
    private int checkNumberofAddons(String name) {
        int count = 0;
        for (int i = 0; i < addons.size(); i++) {
            if (addons.get(i).getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if an addon exists
     * 
     * @return true if addon exists, false otherwise
     */
    private boolean exists(String name) {
        for (int i = 0; i < addons.size(); i++) {
            if (addons.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Clears all addons
     */
    public void clearAddons() {
        addons.clear();
        this.name = "Regular Burger";
    }

    /**
     * Gets the addons
     * 
     * @return addons
     */
    public ArrayList<Addons> getAddons() {
        return addons;
    }

    @Override
    public String getName() {
        // Cheeseburger (2 Cheese slices)
        if (checkNumberofAddons("Cheese slice") == 2 && addons.size() == 2) {
            this.name = "Cheeseburger";
            return name;
        }
        // Bacon Cheeseburger (2 Cheese slices, 2 Bacon strips)
        else if (checkNumberofAddons("Cheese slice") == 2 && checkNumberofAddons("Bacon strip") == 2
                && addons.size() == 4) {
            this.name = "Bacon Cheeseburger";
            return name;
        }
        // Deluxe Burger (1 Lettuce, 1 tomato slice, 1 pickle)
        else if (checkNumberofAddons("Lettuce") == 1 && checkNumberofAddons("Tomato slice") == 1
                && checkNumberofAddons("Pickle slice") == 1 && addons.size() == 3) {
            this.name = "Deluxe Burger";
            return name;
        }
        // Deluxe Cheeseburger (2 Cheese slices, 1 Lettuce, 1 Tomato slice, 1 Pickle)
        else if (checkNumberofAddons("Cheese slice") == 2 && checkNumberofAddons("Lettuce") == 1
                && checkNumberofAddons("Tomato slice") == 1
                && checkNumberofAddons("Pickle slice") == 1 && addons.size() == 5) {
            this.name = "Deluxe Cheeseburger";
            return name;
        }
        // Deluxe Bacon Cheeseburger (2 Cheese slices, 2 Bacon strips, 1 Lettuce, 1
        // Tomato slice, 1 Pickle)
        else if (checkNumberofAddons("Cheese slice") == 2 && checkNumberofAddons("Bacon strip") == 2
                && checkNumberofAddons("Lettuce") == 1 && checkNumberofAddons("Tomato slice") == 1
                && checkNumberofAddons("Pickle slice") == 1 && addons.size() == 7) {
            this.name = "Deluxe Bacon Cheeseburger";
            return name;
        }
        // BLT (3 Bacon strips, 2 Lettuce, 2 Tomato slices)
        else if (checkNumberofAddons("Bacon strip") == 3 && checkNumberofAddons("Lettuce") == 2
                && checkNumberofAddons("Tomato slice") == 2 && addons.size() == 7) {
            this.name = "BLT";
            return name;
        } else {
            if (addons.size() == 0) {
                this.name = "Regular Burger";
                return this.name;
            } else if (addons.size() == 1) {
                this.name = "Custom Burger with " + addons.get(0).getName() + ".";
                return this.name;
            } else {
                this.name = "Custom Burger with ";
                if (exists("Cheese slice")) {
                    this.name = this.name
                            + checkPlural("Cheese slice", checkNumberofAddons("Cheese slice")) + ", ";
                }
                if (exists("Bacon strip")) {
                    this.name = this.name
                            + checkPlural("Bacon strip", checkNumberofAddons("Bacon strip")) + ", ";
                }
                if (exists("Lettuce")) {
                    this.name = this.name + checkPlural("Lettuce", checkNumberofAddons("Lettuce"))
                            + ", ";
                }
                if (exists("Tomato slice")) {
                    this.name = this.name
                            + checkPlural("Tomato slice", checkNumberofAddons("Tomato slice")) + ", ";
                }
                if (exists("Pickle slice")) {
                    this.name = this.name + checkPlural("Pickle slice", checkNumberofAddons("Pickle slice"))
                            + ", ";
                }
                if (exists("Fried Egg")) {
                    this.name = this.name + checkPlural("Fried Egg", checkNumberofAddons("Fried Egg"))
                            + ", ";
                }
                return this.name;
            }
        }
    }

    /**
     * Gets the total price of the burger. This considers the price of the addons to
     * the total price.
     * 
     * @return price of the burger
     */
    @Override
    public int getPrice() {
        int price = super.getPrice();
        for (int i = 0; i < addons.size(); i++) {
            price += addons.get(i).getPrice();
        }
        return price;
    }

    /**
     * Gets the total calories of the burger. This considers the calories of the
     * addons to the total calories.
     * 
     * @return calories of the burger
     */
    @Override
    public float getCalories() {
        float calories = super.getCalories();
        for (int i = 0; i < addons.size(); i++) {
            calories += addons.get(i).getCalories();
        }
        return calories;
    }

}

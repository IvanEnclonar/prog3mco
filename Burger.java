import java.util.ArrayList;

public class Burger extends Item {
    ArrayList<Addons> addons = new ArrayList<Addons>();
    private String name;

    public Burger(int price, float calories) {
        super("Regular Burger", price, calories);
        this.name = "Regular Burger";
    }

    public void addAddons(Addons addon) {
        addons.add(addon);
    }

    private String checkPlural(String name, int count) {
        if (count > 1) {
            return count + " " + name + "s";
        }
        return "a " + name;
    }

    private int checkNumberofAddons(String name) {
        int count = 0;
        for (int i = 0; i < addons.size(); i++) {
            if (addons.get(i).getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    private boolean exists(String name) {
        for (int i = 0; i < addons.size(); i++) {
            if (addons.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearAddons() {
        addons.clear();
    }

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
                return name;
            } else if (addons.size() == 1) {
                this.name = "Custom Burger with " + addons.get(0).getName() + ".";
                return name;
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
                if (exists("Toast")) {
                    this.name = this.name + checkPlural("Toast", checkNumberofAddons("Toast"))
                            + ", ";
                }
                return this.name;
            }
        }
    }

    @Override
    public int getPrice() {
        int price = super.getPrice();
        for (int i = 0; i < addons.size(); i++) {
            price += addons.get(i).getPrice();
        }
        return price;
    }

    @Override
    public float getCalories() {
        float calories = super.getCalories();
        for (int i = 0; i < addons.size(); i++) {
            calories += addons.get(i).getCalories();
        }
        return calories;
    }

}

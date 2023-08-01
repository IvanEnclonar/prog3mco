import java.nio.channels.Pipe;

/**
 * Slot class the represents a slot in the vending machine. Each slot can hold
 * up to 10 items of a single type.
 * 
 */
public class Slot {
    // Instance variables
    private int slotNumber;
    private int itemLimit = 10;
    private int numItems = 0; // Number of items in the slot
    private Item items[] = new Item[itemLimit]; // Array of Items in the slot

    /**
     * Constructor for Slot if you just want to create instance of an empty slot.
     */
    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    /**
     * Constructor for Slot if you want to create an instance of a slot with a
     * specific item and quantity.
     * 
     * @param item     The item to be added to the slot
     * @param quantity The number of items to be added to the slot
     */
    public Slot(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items[i] = item;
        }
        numItems = quantity;
    }

    /**
     * Adds an item to the slot. If the slot is empty, the item is added to the
     * slot. If the slot is not empty, the item is only added if it is the same
     * type as the item already in the slot. If the slot is not empty and the item
     * is the same type as the item already in the slot, the item is added if the
     * slot is not full.
     * 
     * @param item The item to be added to the slot
     * @return true if the item was added, false otherwise
     */
    public boolean addItem(Item item) {
        // Check if the slot is empty
        if (numItems == 0) {
            // If the slot is empty, add the item
            items[0] = item;
            numItems++;
            return true;
        } else {
            // If the slot is not empty, check if the item is the same type as the item and
            // add it if the slot is not full
            if (items[0].getName() != item.getName()) {
                return false;
            } else {
                if (numItems < itemLimit) {
                    items[numItems] = item;
                    numItems++;
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * Sets the price of all items in the slot to the given price.
     * 
     * @param price The price to set all items in the slot to
     */
    public void setItemsPrice(int price) {
        if (price > 0) {
            for (int i = 0; i < numItems; i++) {
                items[i].setPrice(price);
            }
        }
    }

    /**
     * Checks if the slot is empty, and returns the item if it is not empty. If the
     * slot is empty, returns null.
     * 
     * @return The item in the slot, or null if the slot is empty
     */
    public Item checkSlot() {
        if (numItems == 0) {
            return null;
        } else {
            return items[0];
        }
    }

    /**
     * Gets the name of the item in the slot. If the slot is empty, returns "Empty".
     * 
     * @return The name of the item in the slot
     */
    public String getItemName() {
        if (numItems == 0) {
            return "Empty";
        } else {
            return items[0].getName();
        }
    }

    /**
     * Gets the price of the item in the slot. If the slot is empty, returns "0".
     * This method is used for displaying the price of the item.
     * 
     * @return The price of the item in the slot in string form
     */
    public String getPrice() {
        if (numItems == 0) {
            return "0";
        } else {
            return Float.toString(items[0].getPrice());
        }
    }

    /**
     * Removes an item from the slot. If the slot is empty, returns null.
     * 
     * @return The item removed from the slot, or null if the slot is empty
     */
    public Item removeItem() {
        // Check if the slot is empty
        if (numItems > 0) {
            Item holder = items[numItems - 1];
            items[numItems - 1] = null;
            numItems--;
            return holder;
        } else {
            // If the slot is empty, return null
            System.out.println("No items to remove");
            return null;
        }
    }

    /**
     * Return the first item in the slot. If the slot is empty, returns null.
     * 
     * @return The first item in the slot, or null if the slot is empty
     */
    public Item getItems() {
        if (numItems == 0) {
            return null;
        } else {
            return items[0];
        }
    }

    /**
     * Getter function for calories. Is used to display the calories of the item in
     * the slot.
     * 
     * @return The calories of the item in the slot in string form with "cal" added
     *         to the end. If the slot is empty, returns an empty string.
     */
    public String getCalories() {
        if (numItems == 0) {
            return "";
        } else {
            return Float.toString(items[0].getCalories()) + " cal";
        }
    }

    /**
     * Getter function for the number of items in the slot.
     * 
     * @return The number of items in the slot
     */
    public int getNumItems() {
        return numItems;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}

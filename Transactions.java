import java.util.ArrayList;

/**
 * This class is used to record transactions made by the vending machine.
 * It is used to keep track of the number of items sold and the total sales
 * for each type of item.
 */
public class Transactions {
    // Instance variables
    private ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Constructor for Transactions
     */
    public Transactions() {
        // Nothing to do here
    }

    /**
     * Records a transaction in the transactions list
     * 
     * @param item The item to be added to the transactions list
     */
    public void recordTransaction(Item item) {
        items.add(new Item(item.getName(), item.getPrice(), item.getCalories()));
    }

    /**
     * Clears the transactions list by removing all items from the list.
     * This is used when the vending machine is reset.
     */
    public void clearTransactions() {
        items.clear();
    }

    /**
     * Counts the number of items sold for a specific item
     * 
     * @param name The name of the item to be counted
     * @return The number of items sold
     */
    public int countItem(String name) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts the total sales for a specific item
     * 
     * @param name The name of the item
     * @return The total sales for the item
     */
    public int countSales(String name) {
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                count += items.get(i).getPrice();
            }
        }
        return count;
    }
}

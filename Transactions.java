import java.util.ArrayList;

public class Transactions {
    private ArrayList<Item> items = new ArrayList<Item>();

    public Transactions() {
        // Nothing to do here
    }

    public void recordTransaction(Item item) {
        items.add(item);
    }

    public void clearTransactions() {
        items.clear();
    }

    public int countItem(String name) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public int countSales(String name) {
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                count += item.getPrice();
            }
        }
        return count;
    }
}

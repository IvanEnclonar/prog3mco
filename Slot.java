public class Slot {
    private Item items[] = new Item[8];
    private int numItems = 0;

    // Constructor
    public Slot() {
        // Nothing to do here
    }

    public Slot(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items[i] = item;
        }
        numItems = quantity;
    }

    public boolean addItem(Item item, int quantity) {
        if (numItems > 0 && quantity + numItems <= 8) {
            if (items[0].getName().equals(item.getName())) {
                for (int i = 0; i < quantity; i++) {
                    items[numItems + i] = item;
                }
                numItems += quantity;
                return true;
            } else {
                System.out
                        .println(item.getName() + " cannot be added to slot. Slot already contains a different item.");
                return false;
            }
        } else if (numItems == 0 && quantity <= 8) {
            for (int i = 0; i < quantity; i++) {
                items[i] = item;
            }
            numItems = quantity;
            return true;
        } else {
            System.out.println(item.getName() + " cannot be added to slot. Slot is full.");
            return false;
        }
    }
}

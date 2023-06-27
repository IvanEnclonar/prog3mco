public class Slot {
    private int itemLimit = 10;
    private int numItems = 0;
    private Item items[] = new Item[itemLimit];

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

    public boolean addItem(Item item) {
        if (numItems == 0) {
            items[0] = item;
            numItems++;
            return true;
        } else {
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

    public Item checkSlot() {
        if (numItems == 0) {
            return null;
        } else {
            return items[0];
        }
    }

    public Item removeItem() {
        // TODO - might return the first item in the slot, instead of the last item
        if (numItems > 0) {
            Item holder = items[numItems - 1];
            items[numItems - 1] = null;
            numItems--;
            return holder;
        } else {
            System.out.println("No items to remove");
            return null;
        }
    }

    public Item getItems() {
        if (numItems == 0) {
            return null;
        } else {
            return items[0];
        }
    }

    public int getNumItems() {
        return numItems;
    }

}

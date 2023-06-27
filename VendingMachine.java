public class VendingMachine {
    Slot slots[] = new Slot[8];

    public VendingMachine(Item inItems[], int n) {
        // Initialize slots
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
        }
        for (int i = 0; i < n; i++) {
            if (!addItem(inItems[i])) {
                System.out.println("Vending Machine is full");
            }
        }
    }

    public boolean addItem(Item item) {
        // TODO - add item to the first available slot
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].addItem(item)) {
                return true;
            }
        }
        return false;
    }

    public void displayContent() {
        // TODO - display the content of each slot
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].checkSlot() == null) {
                System.out.println("Slot " + (i + 1) + " is empty");
            } else {
                System.out.println("Slot " + (i + 1) + " contains " + slots[i].checkSlot().getName() + " with "
                        + slots[i].getNumItems() + " items");
            }
        }
    }

    public boolean receivePayment(float amount) {
        // TODO - return true if payment is accepted

        return false;
    }

}

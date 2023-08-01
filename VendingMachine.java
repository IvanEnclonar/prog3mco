public class VendingMachine {
    Slot[] slots = new Slot[9];
    int money = 0;
    MoneyBox box = new MoneyBox();
    Transactions transactions = new Transactions();
    String itemNamesList[] = { "Coke", "Sprite", "Royal", "Diet Coke", "Cheese Burger", "Chicken Burger",
            "Bacon Burger",
            "Fries", "Sundae" };


    public VendingMachine() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
        }
    }

    public boolean addItem(Item item, int slotNum) {
        if (slots[slotNum].addItem(item)) {
            return true;
        } else {
            return false;
        }
    }

    public String buyItem(int slotNum) {
        String text = "";
        if (slots[slotNum].checkSlot() != null) {
            if (money < slots[slotNum - 1].checkSlot().getPrice()) {
                text = "Insufficient money";
            } else if (box.haveChange(slots[slotNum - 1].checkSlot().getPrice())) {
                text = "You bought " + slots[slotNum - 1].checkSlot().getName();
                money = money - slots[slotNum - 1].checkSlot().getPrice();
                transactions.recordTransaction(slots[slotNum - 1].checkSlot());
                text = text + "\nDispensing change...";
                slots[slotNum - 1].removeItem();
            } else {
                text = "No change available in the machine.";
            }
        } else {
            text = "Item not available";
        }

        return text;
    }
}

import java.util.ArrayList;

import javax.swing.ButtonGroup;

public class SpecialVendingMachine extends VendingMachine {
    private ArrayList<Item> cart = new ArrayList<Item>();
    Slot[] slots = new Slot[12];
    boolean boughtBurger = false;

    public SpecialVendingMachine() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(i);
        }
    }

    public boolean addToCart(Item item, int slotNum) {
        if (item instanceof Addons) {
            if (boughtBurger) {
                slots[slotNum].removeItem();
                cart.add(item);
                return true;
            } else {
                return false;
            }
        } else if (item instanceof Burger) {
            if (boughtBurger) {
                return false;
            } else {
                slots[slotNum].removeItem();
                cart.add(item);
                boughtBurger = true;
                return true;
            }
        } else {
            slots[slotNum].removeItem();
            cart.add(item);
            return true;
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total = total + cart.get(i).getPrice();
        }
        return total;
    }

    public String buy() {
        String text = "";
        if (cart.size() == 0) {
            text = "Cart is empty";
        } else {
            if (money < getTotalPrice()) {
                text = "Insufficient money";
            } else if (box.haveChange(getTotalPrice())) {
                money = money - getTotalPrice();
                text = "You bought ";
                for (int i = 0; i < cart.size(); i++) {
                    transactions.recordTransaction(cart.get(i));
                    text += cart.get(i).getName() + ", ";
                    // Edit this after
                }
                cart.clear();
                text = text + "\nDispensing change...";
            } else {
                text = "No change available in the machine.";
            }
        }
        return text;
    }
}

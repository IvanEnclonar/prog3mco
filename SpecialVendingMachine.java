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

    public String addToCart(int slotNum) {
        if (slots[slotNum].checkSlot() != null) {
            if (slotNum == 0 && boughtBurger == false) {
                cart.add(slots[slotNum].removeItem());
                boughtBurger = true;
                return "Added to cart";
            } else if (slotNum == 0 && boughtBurger == true) {
                return "You can only buy one burger";
            } else if (slotNum >= 6 && boughtBurger == false) {
                return "You need to buy a burger first";
            } else {
                cart.add(slots[slotNum].removeItem());
                return "Added to cart";
            }
        } else {
            return "Slot is empty";
        }
    }

    public String clearCartString() {
        cart.clear();
        return "Cart cleared";
    }

    public String getCart() {
        // Edit this if you wanna change the text layout.
        if (cart.size() == 0) {
            return "";
        } else {
            String text = "Your cart contains: \n";
            for (int i = 0; i < cart.size(); i++) {
                text = text + cart.get(i).getName() + "\n";
            }
            return text;
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
                text = text + "\n\nDispensing change...";
            } else {
                text = "No change available in the machine.";
            }
        }
        return text;
    }
}

import java.util.ArrayList;

public class SpecialVendingMachine extends VendingMachine {
    private ArrayList<Item> cart = new ArrayList<Item>();
    Slot[] slots = new Slot[12];
    boolean boughtBurger = false;
    String itemNamesList[] = { "Regular Burger", "Fries", "Sundae",
            "Coke", "Diet coke", "Sprite",
            "Fried egg", "Lettuce", "Tomato Slice",
            "Cheese Slice", "Bacon Strip", "Pickle Slice" };

    public SpecialVendingMachine() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(i);
        }
    }

    @Override
    public boolean addItem(Item item, int slotNum) {
        if (slots[slotNum].addItem(item)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String displayTransactions() {
        System.out.println("SIZE" + transactions.getSize());
        String text = "";
        text += "+-------------------------------------------------------------------------------------------------------------------------------------------+";
        text += "\n|                           Item Name                       |         Initital         |     Remaining     |     Sold     |       Total Sales       |";
        text += "\n+-------------------------------------------------------------------------------------------------------------------------------------------+";

        for (int i = 0; i < 12; i++) {
            text += "\n|";
            text += String.format("\t%s\t\t", itemNamesList[i]);
            text += String.format("%-25s", (slots[i].getNumItems() + transactions.countItem(itemNamesList[i])));
            text += String.format("%-20s", slots[i].getNumItems());
            text += String.format("%-18s", transactions.countItem(itemNamesList[i]));
            text += String.format("  %-25s", "Php " + transactions.countSales(itemNamesList[i]));
            text += "|";
        }
        text += "\n+-------------------------------------------------------------------------------------------------------------------------------------------+";
        return text;
    }

    public String restockStandAlones(int choice, int quantity) {
        String text = "Error in restocking. ";
        int price = 0, added = 0;
        float cals = 0;

        if (slots[choice - 1].getPrice() == "" || slots[choice - 1].getCalories() == "") {
            switch (choice) {
                case 1:
                    price = 75;
                    cals = 250;
                    break;
                case 2:
                    price = 45;
                    cals = 50;
                    break;
                case 3:
                    price = 60;
                    cals = 250;
                    break;
                case 4:
                    price = 50;
                    cals = 140;
                    break;
                case 5:
                    price = 60;
                    cals = 0;
                    break;
                case 6:
                    price = 90;
                    cals = 350;
                    break;
            }
        } else {
            price = slots[choice - 1].checkSlot().getPrice();
            cals = slots[choice - 1].checkSlot().getCalories();
        }

        switch (choice) {
            case 1:
                Burger b = new Burger(price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(b, 0)) {
                        added = quantity - i + 1;
                        text = "Slot for Burger is full! Added " + added
                                + " Burger(s) to the inventory.\nTotal pcs. in machine: " + slots[0].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Burger(s) to the inventory\nTotal pcs. in machine: "
                        + slots[0].getNumItems();
                break;
            case 2:
                Item Fries = new Item("Fries", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(Fries, 1)) {
                        added = quantity - i + 1;
                        text = "Slot for Fries is full! Added " + added
                                + " Fries to the inventory.\nTotal pcs. in machine: " + slots[1].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Fries to the inventory.\nTotal pcs. in machine: "
                        + slots[1].getNumItems();
                break;
            case 3:
                Item Sundae = new Item("Sundae", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(Sundae, 2)) {
                        added = quantity - i + 1;
                        text = "Slot for Sundae is full! Added " + added
                                + " Sundae(s) to the inventory.\nTotal pcs. in machine: " + slots[2].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Sundae(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[2].getNumItems();
                break;
            case 4:
                Item Coke = new Item("Coke", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(Coke, 3)) {
                        added = quantity - i + 1;
                        text = "Slot for Coke is full! Added " + added
                                + " Coke(s) to the inventory.\nTotal pcs. in machine: " + slots[3].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Coke(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[3].getNumItems();
                break;
            case 5:
                Item DietCoke = new Item("Diet Coke", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(DietCoke, 4)) {
                        added = quantity - i + 1;
                        text = "Slot for Diet Coke is full! Added " + added
                                + " Diet Coke(s) to the inventory.\nTotal pcs. in machine: " + slots[4].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Diet Coke(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[4].getNumItems();
                break;
            case 6:
                Item Sprite = new Item("Sprite", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(Sprite, 5)) {
                        added = quantity - i + 1;
                        text = "Slot for Sprite is full! Added " + added
                                + " Sprite(s) to the inventory.\nTotal pcs. in machine: " + slots[5].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Sprite(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[5].getNumItems();
                break;
            default:
                break;
        }

        didRestock = true;
        return text;
    }

    public String restockAddOns(int choice, int quantity) {
        String text = "Error in restocking. ";
        int price = 0, added = 0;
        float cals = 0;

        if (slots[choice - 1].getPrice() == "" || slots[choice - 1].getCalories() == "") {
            switch (choice) {
                case 7:
                    price = 25;
                    cals = 100;
                    break;
                case 8:
                    price = 5;
                    cals = 3;
                    break;
                case 9:
                    price = 10;
                    cals = 5;
                    break;
                case 10:
                    price = 15;
                    cals = 80;
                    break;
                case 11:
                    price = 20;
                    cals = 85;
                    break;
                case 12:
                    price = 15;
                    cals = 15;
                    break;
            }
        } else {
            price = slots[choice - 1].checkSlot().getPrice();
            cals = slots[choice - 1].checkSlot().getCalories();
        }

        switch (choice) {
            case 7:
                Addons FriedEgg = new Addons("Fried Egg", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(FriedEgg, 6)) {
                        added = quantity - i + 1;
                        text = "Slot for Fried Egg is full! Added " + added
                                + " Fried Egg(s) to the inventory.\nTotal pcs. in machine: " + slots[6].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Fried Egg(s) to the inventory\nTotal pcs. in machine: "
                        + slots[6].getNumItems();
                break;
            case 8:
                Addons Lettuce = new Addons("Lettuce", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(Lettuce, 7)) {
                        added = quantity - i + 1;
                        text = "Slot for Lettuce is full! Added " + added
                                + " Lettuce(s) to the inventory.\nTotal pcs. in machine: " + slots[7].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Lettuce to the inventory.\nTotal pcs. in machine: "
                        + slots[7].getNumItems();
                break;
            case 9:
                Addons TomatoSlice = new Addons("Tomato slice", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(TomatoSlice, 8)) {
                        added = quantity - i + 1;
                        text = "Slot for Tomato Slice is full! Added " + added
                                + " Tomato Slice(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[8].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Tomato Slice(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[8].getNumItems();
                break;
            case 10:
                Addons CheeseSlice = new Addons("Cheese slice", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(CheeseSlice, 9)) {
                        added = quantity - i + 1;
                        text = "Slot for Cheese Slice is full! Added " + added
                                + " Cheese Slice(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[9].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Cheese Slice(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[9].getNumItems();
                break;
            case 11:
                Addons BaconStrip = new Addons("Bacon strip", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(BaconStrip, 10)) {
                        added = quantity - i + 1;
                        text = "Slot for Bacon Strip is full! Added " + added
                                + " Bacon Strip(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[10].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Bacon Strip(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[10].getNumItems();
                break;
            case 12:
                Addons PickleSlice = new Addons("Pickle slice", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(PickleSlice, 11)) {
                        added = quantity - i + 1;
                        text = "Slot for Pickle Slice is full! Added " + added
                                + " Pickle Slice(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[11].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Pickle Slice(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[11].getNumItems();
                break;
            default:
                break;
        }

        didRestock = true;
        return text;
    }

    public String addToCart(int slotNum) {
        if (slots[slotNum].checkSlot() != null) {
            if (slotNum == 0 && boughtBurger == false) {
                cart.add(slots[slotNum].removeItem());
                boughtBurger = true;
                return "Added to cart";
            } else if (slotNum == 0 && boughtBurger == true) {
                return "You can only buy one Burger";
            } else if (slotNum >= 6 && boughtBurger == false) {
                return "You need to buy a Burger first";
            } else if (slotNum >= 6 && boughtBurger == true) {
                // check cart for burger
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i) instanceof Burger) {
                        Burger b = (Burger) cart.get(i);
                        Addons a = (Addons) slots[slotNum].checkSlot();
                        b.addAddons(a);
                    }
                }
                switch (slotNum) {
                    case 6:
                        return "Frying egg... Added to cart.";
                    case 7:
                        return "Shredding lettuce... Added to cart.";
                    case 8:
                        return "Slicing tomato... Added to cart.";
                    case 9:
                        return "Slicing cheese... Added to cart.";
                    case 10:
                        return "Frying bacon... Added to cart.";
                    case 11:
                        return "Slicing pickle... Added to cart.";
                    default:
                        return "Error";
                }
            } else {
                cart.add(slots[slotNum].removeItem());
                switch (slotNum) {
                    case 0:
                        return "Added Burger to cart.";
                    case 1:
                        return "Added Fries to cart.";
                    case 2:
                        return "Added Sundae to cart.";
                    case 3:
                        return "Added Coke to cart.";
                    case 4:
                        return "Added Diet Coke to cart.";
                    case 5:
                        return "Added Sprite to cart.";
                    case 6:
                        return "Frying egg... Added to cart.";
                    case 7:
                        return "Shredding lettuce... Added to cart.";
                    case 8:
                        return "Slicing tomato... Added to cart.";
                    case 9:
                        return "Slicing cheese... Added to cart.";
                    case 10:
                        return "Frying bacon... Added to cart.";
                    case 11:
                        return "Slicing pickle... Added to cart.";
                    default:
                        return "Error";
                }
            }
        } else {
            return "Slot is empty";
        }
    }

    public String getCart() {
        // Edit this if you wanna change the text layout.
        if (cart.size() == 0) {
            return "Cart is empty.";
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

    public String cancelCart() {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i) instanceof Burger) {
                Burger b = (Burger) cart.get(i);
                for (int j = 0; j < b.getAddons().size(); j++) {
                    if (b.getAddons().get(j).getName().equals("Fried egg")) {
                        slots[6].addItem(b.getAddons().get(j));
                    } else if (b.getAddons().get(j).getName().equals("Lettuce")) {
                        slots[7].addItem(b.getAddons().get(j));
                    } else if (b.getAddons().get(j).getName().equals("Tomato slice")) {
                        slots[8].addItem(b.getAddons().get(j));
                    } else if (b.getAddons().get(j).getName().equals("Cheese slice")) {
                        slots[9].addItem(b.getAddons().get(j));
                    } else if (b.getAddons().get(j).getName().equals("Bacon strip")) {
                        slots[10].addItem(b.getAddons().get(j));
                    } else if (b.getAddons().get(j).getName().equals("Pickle Slice")) {
                        slots[11].addItem(b.getAddons().get(j));
                    }
                }
                b.clearAddons();
            } else {
                if (cart.get(i).getName().equals("Regular Burger")) {
                    slots[0].addItem(cart.get(i));
                } else if (cart.get(i).getName().equals("Fries")) {
                    slots[1].addItem(cart.get(i));
                } else if (cart.get(i).getName().equals("Sundae")) {
                    slots[2].addItem(cart.get(i));
                } else if (cart.get(i).getName().equals("Coke")) {
                    slots[3].addItem(cart.get(i));
                } else if (cart.get(i).getName().equals("Diet Coke")) {
                    slots[4].addItem(cart.get(i));
                } else if (cart.get(i).getName().equals("Sprite")) {
                    slots[5].addItem(cart.get(i));
                }
            }
        }
        boughtBurger = false;
        cart.clear();
        return "Cart cleared.";
    }

    public String buy() {
        String text = "";
        money = money + box.getTotalUserMoney();
        if (cart.size() == 0) {
            text = "Cart is empty";
        } else {
            if (money < getTotalPrice()) {
                text = "Insufficient money";
            } else if (box.haveChange(getTotalPrice())) {

                money = money - getTotalPrice();
                text = "You bought: \n";
                for (int i = 0; i < cart.size(); i++) {
                    if (cart.get(i) instanceof Burger) {
                        Burger b = (Burger) cart.get(i);
                        text += b.getName() + "\n";
                        for (int j = 0; j < b.getAddons().size(); j++) {
                            transactions.recordTransaction(b.getAddons().get(j));
                        }
                        b.clearAddons();
                        transactions.recordTransaction(b);
                    } else {
                        transactions.recordTransaction(cart.get(i));
                        text += cart.get(i).getName() + "\n ";
                    }
                    // Edit this after
                }
                cart.clear();
                text = text + "\n\nDispensing change...";
                text = text + "\n\nChange dispensed: " + box.getChange(getTotalPrice());
            } else {
                text = "No change available in the machine.";
            }
        }
        return text;
    }
}

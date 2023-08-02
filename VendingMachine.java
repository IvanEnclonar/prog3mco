/**
 * This class is used to create a vending machine object. It simulates a vending
 * machine in real life and allows the user to add items to the machine, add
 * money to the machine, and purchase items from the machine.
 */
public class VendingMachine {
    Slot[] slots = new Slot[9];
    int money = 0;
    MoneyBox box = new MoneyBox();
    Transactions transactions = new Transactions();
    String itemNamesList[] = { "Coke", "Sprite", "Royal", "Diet Coke", "Cheese Burger", "Chicken Burger",
            "Bacon Burger",
            "Fries", "Sundae" };
    boolean didRestock = false;

    /**
     * Constructor for VendingMachine. It initializes the slots array.
     */
    public VendingMachine() {
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot(i);
        }
    }

    /**
     * This method is used to add items to the vending machine. It takes in an item,
     * and a slot number to add the item to the slots array. It returns true if the
     * item was added successfully, and false if the item was not added.
     * 
     * @param item    item to be added
     * @param slotNum slot number to add the item to
     * @return true if item was added successfully, false if item was not added
     */
    public boolean addItem(Item item, int slotNum) {
        if (slots[slotNum].addItem(item)) {
            // Print out the slots
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method restocks the items in the vending machine. It creates a new Item
     * object depending on the user's choice and then adds it to the appropriate
     * slot.
     * 
     * @param choice slot number of the item to restock
     * @param quantity number of items to restock
     * @return confirmation message for if the item was restocked
     */
    public String restockItems(int choice, int quantity) {
        String text = "Error in restocking. ";
        int price = 0, added = 0;
        float cals = 0;

        if (slots[choice - 1].getPrice() == "" || slots[choice - 1].getCalories() == "") {
            switch (choice) {
                case 1:
                    price = 50;
                    cals = 140;
                    break;
                case 2:
                    price = 45;
                    cals = 50;
                    break;
                case 3:
                    price = 40;
                    cals = 100;
                    break;
                case 4:
                    price = 60;
                    cals = 0;
                    break;
                case 5:
                    price = 80;
                    cals = 300;
                    break;
                case 6:
                    price = 90;
                    cals = 350;
                    break;
                case 7:
                    price = 100;
                    cals = 400;
                    break;
                case 8:
                    price = 50;
                    cals = 200;
                    break;
                case 9:
                    price = 60;
                    cals = 250;
                    break;
            }
        } else {
            price = slots[choice - 1].checkSlot().getPrice();
            cals = slots[choice - 1].checkSlot().getCalories();
        }

        switch (choice) {
            case 1:
                Item coke = new Item("Coke", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(coke, 0)) {
                        added = quantity - i + 1;
                        text = "Slot for Coke is full! Added " + added
                                + " Coke(s) to the inventory.\nTotal pcs. in machine: " + slots[0].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " coke(s) to the inventory\nTotal pcs. in machine: "
                        + slots[0].getNumItems();
                break;
            case 2:
                Item sprite = new Item("Sprite", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(sprite, 1)) {
                        added = quantity - i + 1;
                        text = "Slot for Sprite is full! Added " + added
                                + " Sprite(s) to the inventory.\nTotal pcs. in machine: " + slots[1].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Sprite(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[1].getNumItems();
                break;
            case 3:
                Item royal = new Item("Royal", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(royal, 2)) {
                        added = quantity - i + 1;
                        text = "Slot for Royal is full! Added " + added
                                + " Royal(s) to the inventory.\nTotal pcs. in machine: " + slots[2].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Royal(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[2].getNumItems();
                break;
            case 4:
                Item dietCoke = new Item("Diet Coke", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(dietCoke, 3)) {
                        added = quantity - i + 1;
                        text = "Slot for Diet Coke is full! Added " + added
                                + " Diet Coke(s) to the inventory.\nTotal pcs. in machine: " + slots[3].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Diet Coke(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[3].getNumItems();
                break;
            case 5:
                Item cheeseBurger = new Item("Cheese Burger", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(cheeseBurger, 4)) {
                        added = quantity - i + 1;
                        text = "Slot for Cheese Burger is full! Added " + added
                                + " Cheese Burger(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[4].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Cheese Burger(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[4].getNumItems();
                break;
            case 6:
                Item chickenBurger = new Item("Chicken Burger", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(chickenBurger, 5)) {
                        added = quantity - i + 1;
                        text = "Slot for Chicken Burger is full! Added " + added
                                + " Chicken Burger(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[5].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Chicken Burger(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[5].getNumItems();
                break;
            case 7:
                Item baconBurger = new Item("Bacon Burger", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(baconBurger, 6)) {
                        added = quantity - i + 1;
                        text = "Slot for Bacon Burger is full! Added " + added
                                + " Bacon Burger(s) to the inventory.\nTotal pcs. in machine: "
                                + slots[6].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Bacon Burger(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[6].getNumItems();
                break;
            case 8:
                Item fries = new Item("Fries", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(fries, 7)) {
                        added = quantity - i + 1;
                        text = "Slot for Fries is full! Added " + added
                                + " Fries to the inventory.\nTotal pcs. in machine: " + slots[7].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Fries to the inventory.\nTotal pcs. in machine: "
                        + slots[7].getNumItems();
                break;
            case 9:
                Item sundae = new Item("Sundae", price, cals);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(sundae, 8)) {
                        added = quantity - i + 1;
                        text = "Slot for Sundae is full! Added " + added
                                + " Sundae(s) to the inventory.\nTotal pcs. in machine: " + slots[8].getNumItems();
                        break;
                    }
                }
                text = "Added " + quantity + " Sundae(s) to the inventory.\nTotal pcs. in machine: "
                        + slots[8].getNumItems();
                break;
            default:
                break;
        }

        didRestock = true;
        return text;
    }

    /**
     * Changes the price of an item
     * 
     * @param choice  index of the item to change the price of
     * @param newPrice  the new price of the item
     * @return a string that tells the user if the price was changed or not
     */
    public String changePrice(int choice, int newPrice) {
        String name = "";
        // Set name to the name of the item chosen
        switch (choice) {
            case 1:
                name = "Coke";
                break;
            case 2:
                name = "Sprite";
                break;
            case 3:
                name = "Royal";
                break;
            case 4:
                name = "Diet Coke";
                break;
            case 5:
                name = "Cheese Burger";
                break;
            case 6:
                name = "Chicken Burger";
                break;
            case 7:
                name = "Bacon Burger";
                break;
            case 8:
                name = "Fries";
                break;
            case 9:
                name = "Sundae";
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        // If the item is not null, loop through the slots array and find the slot and
        // then use the setItemsPrice method.
        if (!name.equals("")) {
            for (int i = 0; i < slots.length; i++) {
                if (slots[i].getItemName().equals(name)) {
                    slots[i].setItemsPrice(newPrice);
                }
            }
        }

        return name + " price changed to P" + newPrice;
    }

    /**
     * This method is used to buy an item from the vending machine. Aside from
     * checking the item exists It checks if the user has enough money to buy the
     * item.
     * 
     * @param slotNum the slot number of the item to be bought
     * @return a string confirming if the item was bought or not
     */
    public String buyItem(int slotNum) {
        String text = "";
        money = box.getTotalUserMoney();
        if (slots[slotNum].checkSlot() != null) {
            if (money < slots[slotNum].checkSlot().getPrice()) {
                text = "Insufficient money";
            } else {
                text = "You bought " + slots[slotNum].checkSlot().getName();
                money = money - slots[slotNum].checkSlot().getPrice();
                transactions.recordTransaction(slots[slotNum].checkSlot());
                slots[slotNum].removeItem();
            }
        } else {
            text = "Item not available";
        }

        return text;
    }

    /**
     * This method is used to get the transactions of the vending machine
     * 
     * @return a string that displays the transactions recorded
     */
    public String displayTransactions() {
        String text = "";
        text += "+-------------------------------------------------------------------------------------------------------------------------------------------+";
        text += "\n|                           Item Name                       |         Initital         |     Remaining     |     Sold     |       Total Sales       |";
        text += "\n+-------------------------------------------------------------------------------------------------------------------------------------------+";

        for (int i = 0; i < 9; i++) {
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

    /**
     * This method returns if the vending machine has been restocked or not
     * @return didRestock value
     */
    public boolean didRestock() {
        return didRestock;
    }
}
import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

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

    public void displayContent() {

        for (int i = 0; i < slots.length; i += 3) {
            if (i == 0) {
                System.out.println("\n+-----------------+-----------------+-----------------+");
            }
            System.out.println("|                 |                 |                 |");
            System.out.println("| " + String.format("%-" + 16 + "s", slots[i].getItemName()) + "| "
                    + String.format("%-" + 16 + "s", slots[i + 1].getItemName()) + "| "
                    + String.format("%-" + 16 + "s", slots[i + 2].getItemName()) + "|");
            System.out.println("| " + String.format("%-" + 16 + "s", slots[i].getCalories()) + "| "
                    + String.format("%-" + 16 + "s", slots[i + 1].getCalories()) + "| "
                    + String.format("%-" + 16 + "s", slots[i + 2].getCalories()) + "|");
            System.out.println("+-----------------+-----------------+-----------------+");
            System.out.println("| [" + (i + 1) + "] Php " + String.format("%-" + 8 + "s", slots[i].getPrice()) + "| ["
                    + (i + 2)
                    + "] Php " + String.format("%-" + 8 + "s", slots[i + 1].getPrice()) + "| [" + (i + 3) + "] Php "
                    + String.format("%-" + 8 + "s", slots[i + 2].getPrice()) + "|");
            System.out.println("+-----------------+-----------------+-----------------+");
        }
    }

    /*
     * private int getNumInput() {
     * Scanner sc = new Scanner(System.in);
     * int num = 0;
     * try {
     * num = sc.nextInt();
     * } catch (Exception e) {
     * System.out.println("Invalid input");
     * }
     * sc.close();
     * return num;
     * }
     */

    public void menu(Scanner sc) {
        int choice;
        do {
            displayContent();
            money = box.getTotalUserMoney();
            System.out.println("\nMoney: Php " + money);
            System.out.println("[1] Insert money");
            System.out.println("[2] Buy item");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    box.insertMoney(sc);
                    money = box.getTotalUserMoney();
                    break;
                case 2:
                    System.out.print("Enter slot number: ");
                    int slotNum = sc.nextInt();
                    if (slotNum > 0 && slotNum <= 9) {
                        Item item = buyItem(slotNum);
                        if (item != null && box.haveChange(item.getPrice())) {
                            System.out.println("\nYou bought " + item.getName());
                            box.dispenseChange();
                            System.out.println("\nTotal money dispensed: Php " + money + "\n");
                        } else {
                            if (!box.haveChange(item.getPrice())) {
                                System.out.println("No change available in the machine. ");
                            } else
                                System.out.println("Item not available. ");
                        }
                    } else {
                        System.out.println("Invalid slot number");
                    }
                    break;
                case 0:
                    if (money > 0) {
                        if (box.haveChange(0))
                            box.dispenseChange();
                        System.out.println("\nTotal money dispensed: Php " + money + "\n");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

    }

    public void changePrice(Scanner sc) {
        String name = "";
        int price;
        System.out.println("Choose which item to change price: ");
        printSetItemList();
        System.out.print("Choice: ");
        int choice = sc.nextInt();
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
        if (!name.equals("")) {
            System.out.print("Enter new price: ");
            price = sc.nextInt();
            for (int i = 0; i < slots.length; i++) {
                if (slots[i].getItemName().equals(name)) {
                    slots[i].setItemsPrice(price);
                }
            }
        }
        // item.setPrice(price);
    }

    public void printSetItemList() {
        System.out.println("[1] Coke");
        System.out.println("[2] Sprite");
        System.out.println("[3] Royal");
        System.out.println("[4] Diet Coke");
        System.out.println("[5] Cheese Burger");
        System.out.println("[6] Chicken Burger");
        System.out.println("[7] Bacon Burger");
        System.out.println("[8] Fries");
        System.out.println("[9] Sundae");
    }

    public void restockItems(Scanner sc) {
        System.out.println("\nChoose which item to restock: ");
        printSetItemList();
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        switch (choice) {
            case 1:
                Item coke = new Item("Coke", 50, 140);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(coke, 0)) {
                        System.out.println("Slot for coke is full!");
                        break;
                    }
                }
                break;
            case 2:
                Item sprite = new Item("Sprite", 45, 50);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(sprite, 1)) {
                        System.out.println("Slot for sprite is full!");
                        break;
                    }
                }
                break;
            case 3:
                Item royal = new Item("Royal", 40, 100);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(royal, 2)) {
                        System.out.println("Slot for royal is full!");
                        break;
                    }
                }
                break;
            case 4:
                Item dietCoke = new Item("Diet Coke", 60, 0);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(dietCoke, 3)) {
                        System.out.println("Slot for diet coke is full!");
                        break;
                    }
                }
                break;
            case 5:
                Item cheeseBurger = new Item("Cheese Burger", 80, 300);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(cheeseBurger, 4)) {
                        System.out.println("Slot for cheese burger is full!");
                        break;
                    }
                }
                break;
            case 6:
                Item chickenBurger = new Item("Chicken Burger", 90, 350);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(chickenBurger, 5)) {
                        System.out.println("Slot for chicken burger is full!");
                        break;
                    }
                }
                break;
            case 7:
                Item baconBurger = new Item("Bacon Burger", 100, 400);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(baconBurger, 6)) {
                        System.out.println("Slot for bacon burger is full!");
                        break;
                    }
                }
                break;
            case 8:
                Item fries = new Item("Fries", 50, 200);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(fries, 7)) {
                        System.out.println("Slot for fries is full!");
                        break;
                    }
                }
                break;
            case 9:
                Item sundae = new Item("Sundae", 60, 250);
                for (int i = 0; i < quantity; i++) {
                    if (!addItem(sundae, 8)) {
                        System.out.println("Slot for sundae is full!");
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }

    public Item buyItem(int slotNum) {
        if (slots[slotNum - 1].checkSlot() != null) {
            if (money > slots[slotNum - 1].checkSlot().getPrice()) {
                money = money - slots[slotNum - 1].checkSlot().getPrice();
                transactions.recordTransaction(slots[slotNum - 1].checkSlot());
                return slots[slotNum - 1].removeItem();
            } else {
                System.out.println("Insufficient funds");
                return null;
            }
        } else {
            return null;
        }
    }

    public void displayTransactions() {
        System.out.println("\nTRANSACTIONS");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("|   Item Name   | Initital | Remaining | Sold | Total Sales |");
        System.out.println("+-----------------------------------------------------------+");

        for (int i = 0; i < 9; i++) {
            System.out.print("|");
            System.out.print(String.format("%15s", itemNamesList[i]));
            System.out.print("|");
            System.out
                    .print(String.format("%10s", (slots[i].getNumItems() + transactions.countItem(itemNamesList[i]))));
            System.out.print("|");
            System.out.print(String.format("%11s", slots[i].getNumItems()));
            System.out.print("|");
            System.out.print(String.format("%6s", transactions.countItem(itemNamesList[i])));
            System.out.print("|");
            System.out.print(
                    String.format("%13s", "Php " + transactions.countSales(itemNamesList[i])));
            System.out.print("|\n");
        }
        System.out.println("+-----------------------------------------------------------+");

    }

    public void maintenance(Scanner sc) {
        int choice = 0;
        boolean exit = false;
        boolean didRestock = false;

        while (!exit) {
            System.out.println("\nMAINTENANCE ONGOING");
            System.out.println("[1] Restock Item");
            System.out.println("[2] Change Item Price");
            System.out.println("[3] Replenish Money");
            System.out.println("[4] Collect Money");
            System.out.println("[5] Display Transactions");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    didRestock = true;
                    restockItems(sc);
                    break;
                case 2:
                    changePrice(sc);
                    break;
                case 3:
                    box.displayBoxContents();
                    if (box.replenishMoney(sc)) {
                        System.out.println("Denomination replenished.");
                    } else {
                        System.out.println("Error in replenishing money. Please try again.");
                    }
                    break;
                case 4:
                    box.displayBoxContents();
                    if (box.collectMoney()) {
                        System.out.println("Money collected.");
                    } else {
                        System.out.println("Error in collecting money.");
                    }
                    break;
                case 5:
                    displayTransactions();
                    break;
                case 0:
                    if (didRestock) {
                        transactions.clearTransactions();
                        System.out.println("Transactions history cleared.");
                    }
                    System.out.println();
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}

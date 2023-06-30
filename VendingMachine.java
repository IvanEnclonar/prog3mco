import java.util.Scanner;

public class VendingMachine {
    Slot slots[] = new Slot[9];
    MoneyBox mb = new MoneyBox();
    float money = 0;

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
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].addItem(item)) {
                return true;
            }
        }
        return false;
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

    private int getNumInput() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        sc.close();
        return num;
    }

    public void menu() {
        int choice;
        do {
            displayContent();
            System.out.println("\nMoney: Php " + money);
            System.out.println("[1] Insert money");
            System.out.println("[2] Buy item");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = getNumInput();
            switch (choice) {
                case 1:
                    money = money + insertMoney();
                    break;
                case 2:
                    System.out.print("Enter slot number: ");
                    int slotNum = getNumInput();
                    if (slotNum > 0 && slotNum <= 9) {
                        Item item = buyItem(slotNum);
                        if (item != null) {
                            System.out.println("\nYou bought " + item.getName());
                        } else {
                            System.out.println("Item not available");
                        }
                    } else {
                        System.out.println("Invalid slot number");
                    }
                    break;
                case 0:
                    if (money > 0) {
                        System.out.println("Change: Php " + money);
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

    }

    public Item buyItem(int slotNum) {
        if (slots[slotNum - 1].checkSlot() != null) {
            if (money > slots[slotNum - 1].checkSlot().getPrice()) {
                money = money - slots[slotNum - 1].checkSlot().getPrice();
                return slots[slotNum - 1].removeItem();
            } else {
                System.out.println("Insufficient funds");
                return null;
            }
        } else {
            return null;
        }
    }

    public int insertMoney() {
        Scanner sc = new Scanner(System.in);
        int totalInp = 0;
        int temp = 0;

        System.out.print("Insert money (1 5 10 20 50 100): ");
        String moneyInp = sc.nextLine();

        String[] moneyArr = moneyInp.split(" ");

        for (int i = 0; i < moneyArr.length; i++) {
            temp = Integer.parseInt(moneyArr[i]);
            switch (temp) {
                case 1:
                case 5:
                case 10:
                case 20:
                case 50:
                case 100:
                case 200:
                case 500:
                case 1000:
                    totalInp = totalInp + temp;
                    break;
                default:
                    System.out.println(temp + " is an invalid denomination.");
            }
        }
        sc.close();
        return totalInp;
    }

}

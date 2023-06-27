import java.util.Scanner;

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

    public Item buyItem(int slotNum) {
        // TODO - return the item in the slot if it exists
        if (slots[slotNum - 1].getNumItems() > 0) {
            return slots[slotNum - 1].removeItem();
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

        for (int i = 0; i < moneyArr.length; i++){
            temp = Integer.parseInt(moneyArr[i]);
            switch (temp){
                case 1:
                case 5:
                case 10:
                case 20:
                case 50:
                case 100:
                case 200:
                case 500:
                case 1000:
                    totalInp = totalInp + temp; break;
                default:
                    System.out.println(temp + " is an invalid denomination.");
            }
        }
        System.out.println("Total money inserted: " + totalInp);
        return totalInp;
    }

}

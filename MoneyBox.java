import java.util.Scanner;

/**
 * This class is used to keep track of the bills and coins in the vending
 * machine. It is also used to check if the user has inserted enough money to
 * buy an item, and to return change to the user.
 */
public class MoneyBox {
    // Instance variables
    private int[] money = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // The bills and coins that the machine has in 1 5 10 20 50 100
                                                         // 200 500 1000 format. The value corresponds to number of
                                                         // bills or coins.
    private int[] change = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // Change to be returned to the user in the same format as
                                                          // money.
    private int totalUserMoney = 0; // The total amount of money that the user has inserted into the machine.

    /**
     * Constructor for MoneyBox
     */
    public MoneyBox() {
    }

    /**
     * Method to insert money into the vending machine.
     * 
     * @param sc Scanner object to get input from the user
     */
    public void insertMoney(Scanner sc) {
        int temp = 0;

        // Get input from the user
        System.out.print("Insert money (1 5 10 20 50 100 200 500 1000): ");
        sc.nextLine();
        String moneyInp = sc.nextLine();

        System.out.println();
        // Split the input into an array
        String[] moneyArr = moneyInp.split(" ");

        // Loop through the array and add the money to the machine
        for (int i = 0; i < moneyArr.length; i++) {
            temp = Integer.parseInt(moneyArr[i]);
            switch (temp) {
                case 1:
                    money[0] = money[0] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("1 peso inserted.");
                    break;
                case 5:
                    money[1] = money[1] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("5 pesos inserted.");
                    break;
                case 10:
                    money[2] = money[2] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("10 pesos inserted.");
                    break;
                case 20:
                    money[3] = money[3] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("20 pesos inserted.");
                    break;
                case 50:
                    money[4] = money[4] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("50 pesos inserted.");
                    break;
                case 100:
                    money[5] = money[5] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("100 pesos inserted.");
                    break;
                case 200:
                    money[6] = money[6] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("200 pesos inserted.");
                    break;
                case 500:
                    money[7] = money[7] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("500 pesos inserted.");
                    break;
                case 1000:
                    money[8] = money[8] + 1;
                    totalUserMoney = totalUserMoney + temp;
                    System.out.println("1000 pesos inserted.");
                    break;
                default:
                    System.out.println(temp + " is an invalid denomination.");
            }
        }
    }

    /**
     * Checks if there is enough change in the machine to dispense to the user.
     * 
     * @param productTotal The total cost of the product that the user wants to buy
     * @return true if there is enough change, false if there is not enough change
     */
    public boolean haveChange(int productTotal) {
        int toDispense = totalUserMoney - productTotal;

        // If the user has not inserted enough money, return false
        if (toDispense < 0)
            return false;

        // Store initial values of money array
        int[] tempMoney = money;

        // Set change array to 0
        for (int i = 0; i < 9; i++)
            change[i] = 0;

        // Check if there is change, increment corresponding element in change array
        while (toDispense >= 1000 && money[8] > 0) {
            toDispense = toDispense - 1000;
            change[8] = change[8] + 1;
        }
        while (toDispense >= 500 && money[7] > 0) {
            toDispense = toDispense - 500;
            change[7] = change[7] + 1;
        }
        while (toDispense >= 200 && money[6] > 0) {
            toDispense = toDispense - 200;
            change[6] = change[6] + 1;
        }
        while (toDispense >= 100 && money[5] > 0) {
            toDispense = toDispense - 100;
            change[5] = change[5] + 1;
        }
        while (toDispense >= 50 && money[4] > 0) {
            toDispense = toDispense - 50;
            change[4] = change[4] + 1;
        }
        while (toDispense >= 20 && money[3] > 0) {
            toDispense = toDispense - 20;
            change[3] = change[3] + 1;
        }
        while (toDispense >= 10 && money[2] > 0) {
            toDispense = toDispense - 10;
            change[2] = change[2] + 1;
        }
        while (toDispense >= 5 && money[1] > 0) {
            toDispense = toDispense - 5;
            change[1] = change[1] + 1;
        }
        while (toDispense >= 1 && money[0] > 0) {
            toDispense = toDispense - 1;
            change[0] = change[0] + 1;
        }

        // If there is enough change, return true
        if (toDispense == 0)
            return true;
        else {
            // If there is not enough change, revert money array and return false
            money = tempMoney;
            return false;
        }
    }

    /**
     * Dispenses the change to the user.
     */
    public void dispenseChange() {
        // Loop through money array and dispense the change, decrement corresponding
        // denomination in money array
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    money[0] = money[0] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("1 ");
                    break;
                case 1:
                    money[1] = money[1] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("5 ");
                    break;
                case 2:
                    money[2] = money[2] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("10 ");
                    break;
                case 3:
                    money[3] = money[3] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("20 ");
                    break;
                case 4:
                    money[4] = money[4] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("50 ");
                    break;
                case 5:
                    money[5] = money[5] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("100 ");
                    break;
                case 6:
                    money[6] = money[6] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("200 ");
                    break;
                case 7:
                    money[7] = money[7] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("500 ");
                    break;
                case 8:
                    money[8] = money[8] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        System.out.print("1000 ");
                    break;
            }
        }
        // Reset change array
        for (int i = 0; i < 9; i++)
            change[i] = 0;
        // Reset totalUserMoney
        totalUserMoney = 0;
    }

    /**
     * Displays the contents of the box
     */
    public void displayBoxContents() {
        int tempTotal = 0;
        int total = 0;
        System.out.println();
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    tempTotal = money[i] * 1;
                    total = total + tempTotal;
                    System.out.println("1 peso: " + money[i] + " pcs." + "\t\t[" + tempTotal + " pesos]");
                    break;
                case 1:
                    tempTotal = money[i] * 5;
                    total = total + tempTotal;
                    System.out.println("5 pesos: " + money[i] + " pcs." + "\t\t[" + tempTotal + " pesos]");
                    break;
                case 2:
                    tempTotal = money[i] * 10;
                    total = total + tempTotal;
                    System.out.println("10 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
                case 3:
                    tempTotal = money[i] * 20;
                    total = total + tempTotal;
                    System.out.println("20 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
                case 4:
                    tempTotal = money[i] * 50;
                    total = total + tempTotal;
                    System.out.println("50 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
                case 5:
                    tempTotal = money[i] * 100;
                    total = total + tempTotal;
                    System.out.println("100 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
                case 6:
                    tempTotal = money[i] * 200;
                    total = total + tempTotal;
                    System.out.println("200 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
                case 7:
                    tempTotal = money[i] * 500;
                    total = total + tempTotal;
                    System.out.println("500 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
                case 8:
                    tempTotal = money[i] * 1000;
                    total = total + tempTotal;
                    System.out.println("1000 pesos: " + money[i] + " pcs." + "\t[" + tempTotal + " pesos]");
                    break;
            }
        }
        System.out.println("Total: " + total + " pesos");
    }

    /**
     * Helper method that adds to the money array given denomination and number to
     * add
     * 
     * @param money denomination of money to add
     * @param count number of money to add
     */
    private void restockingMoney(int money, int count) {
        switch (money) {
            case 1:
                this.money[0] = this.money[0] + count;
                break;
            case 5:
                this.money[1] = this.money[1] + count;
                break;
            case 10:
                this.money[2] = this.money[2] + count;
                break;
            case 20:
                this.money[3] = this.money[3] + count;
                break;
            case 50:
                this.money[4] = this.money[4] + count;
                break;
            case 100:
                this.money[5] = this.money[5] + count;
                break;
            case 200:
                this.money[6] = this.money[6] + count;
                break;
            case 500:
                this.money[7] = this.money[7] + count;
                break;
            case 1000:
                this.money[8] = this.money[8] + count;
                break;
        }
    }

    /**
     * Method that prompts the user to input a denomination and number of money to
     * add
     * 
     * @param sc Scanner object
     * @return true replenish was successful, false otherwise
     */
    public boolean replenishMoney(Scanner sc) {
        System.out.println();
        System.out.print("Enter denomination: ");
        int money = sc.nextInt();
        switch (money) {
            case 1:
            case 5:
            case 10:
            case 20:
            case 50:
            case 100:
            case 200:
            case 500:
            case 1000:
                System.out.print("Enter count: ");
                int count = sc.nextInt();
                restockingMoney(money, count);
                return true;
            default:
                System.out.println("Invalid denomination.");
                return false;
        }
    }

    /**
     * Collects all the money in this MoneyBox
     * 
     * @return true if there is money to collect and it is collected successfully,
     *         false otherwise
     */
    public boolean collectMoney() {
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (money[i] == 0)
                count++;
        }

        if (count == 9) {
            System.out.println("No money to collect.");
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                money[i] = 0;
            }
            return true;
        }

    }

    /**
     * Returns the money that the user has
     * 
     * @return totalUserMoney
     */
    public int getTotalUserMoney() {
        return totalUserMoney;
    }
}
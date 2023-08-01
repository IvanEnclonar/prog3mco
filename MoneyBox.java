public class MoneyBox {
    // Instance variables
    private int[] money = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // The bills and coins that the machine has in 1 5 10 20 50 100
                                                         // 200 500 1000 format. The value corresponds to number of
                                                         // bills or coins.
    private int[] change = { 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // Change to be returned to the user in the same format as
                                                          // money.
    private int totalUserMoney = 0; // The total amount of money that the user has inserted into the machine.

    public MoneyBox() {
    }

    public String insertMoney(int i){
        String text = "";
        switch (i) {
            case 1:
                money[0] = money[0] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "1 peso inserted.";
                break;
            case 5:
                money[1] = money[1] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "5 pesos inserted.";
                break;
            case 10:
                money[2] = money[2] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "10 pesos inserted.";
                break;
            case 20:
                money[3] = money[3] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "20 pesos inserted.";
                break;
            case 50:
                money[4] = money[4] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "50 pesos inserted.";
                break;
            case 100:
                money[5] = money[5] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "100 pesos inserted.";
                break;
            case 200:
                money[6] = money[6] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "200 pesos inserted.";
                break;
            case 500:
                money[7] = money[7] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "500 pesos inserted.";
                break;
            case 1000:
                money[8] = money[8] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "1000 pesos inserted.";
                break;
        }

        return text;
    }

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

    public String dispenseChange() {
        String text = "";
        // Loop through money array and dispense the change, decrement corresponding
        // denomination in money array
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    money[0] = money[0] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "1 ";
                    break;
                case 1:
                    money[1] = money[1] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "5 ";
                    break;
                case 2:
                    money[2] = money[2] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "10 ";
                    break;
                case 3:
                    money[3] = money[3] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "20 ";
                    break;
                case 4:
                    money[4] = money[4] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "50 ";
                    break;
                case 5:
                    money[5] = money[5] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "100 ";
                    break;
                case 6:
                    money[6] = money[6] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "200 ";
                    break;
                case 7:
                    money[7] = money[7] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "500 ";
                    break;
                case 8:
                    money[8] = money[8] - change[i];
                    for (int j = 0; j < change[i]; j++)
                        text = text + "1000 ";
                    break;
            }
        }
        // Reset change array
        for (int i = 0; i < 9; i++)
            change[i] = 0;
        // Reset totalUserMoney
        totalUserMoney = 0;

        return text;
    }

    public int getTotalUserMoney() {
        return totalUserMoney;
    }

}

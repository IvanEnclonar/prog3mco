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
                change[0] = change[0] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "1 peso inserted.";
                break;
            case 5:
                money[1] = money[1] + 1;
                change[1] = change[1] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "5 pesos inserted.";
                break;
            case 10:
                money[2] = money[2] + 1;
                change[2] = change[2] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "10 pesos inserted.";
                break;
            case 20:
                money[3] = money[3] + 1;
                change[3] = change[3] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "20 pesos inserted.";
                break;
            case 50:
                money[4] = money[4] + 1;
                change[4] = change[4] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "50 pesos inserted.";
                break;
            case 100:
                money[5] = money[5] + 1;
                change[5] = change[5] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "100 pesos inserted.";
                break;
            case 200:
                money[6] = money[6] + 1;
                change[6] = change[6] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "200 pesos inserted.";
                break;
            case 500:
                money[7] = money[7] + 1;
                change[7] = change[7] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "500 pesos inserted.";
                break;
            case 1000:
                money[8] = money[8] + 1;
                change[8] = change[8] + 1;
                totalUserMoney = totalUserMoney + i;
                text = "1000 pesos inserted.";
                break;
        }

        return text;
    }

    public boolean haveChange(int productTotal) {
        int toDispense = totalUserMoney - productTotal;
        int[] tempMoney = money;
        int[] tempChange = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        while(toDispense >= 1000 & tempMoney[8] > 0){
            tempMoney[8] = tempMoney[8] - 1;
            tempChange[8] = tempChange[8] + 1;
            toDispense = toDispense - 1000;
        }
        while(toDispense >= 500 & tempMoney[7] > 0){
            tempMoney[7] = tempMoney[7] - 1;
            tempChange[7] = tempChange[7] + 1;
            toDispense = toDispense - 500;
        }
        while(toDispense >= 200 & tempMoney[6] > 0){
            tempMoney[6] = tempMoney[6] - 1;
            tempChange[6] = tempChange[6] + 1;
            toDispense = toDispense - 200;
        }
        while(toDispense >= 100 & tempMoney[5] > 0){
            tempMoney[5] = tempMoney[5] - 1;
            tempChange[5] = tempChange[5] + 1;
            toDispense = toDispense - 100;
        }
        while(toDispense >= 50 & tempMoney[4] > 0){
            tempMoney[4] = tempMoney[4] - 1;
            tempChange[4] = tempChange[4] + 1;
            toDispense = toDispense - 50;
        }
        while(toDispense >= 20 & tempMoney[3] > 0){
            tempMoney[3] = tempMoney[3] - 1;
            tempChange[3] = tempChange[3] + 1;
            toDispense = toDispense - 20;
        }
        while(toDispense >= 10 & tempMoney[2] > 0){
            tempMoney[2] = tempMoney[2] - 1;
            tempChange[2] = tempChange[2] + 1;
            toDispense = toDispense - 10;
        }
        while(toDispense >= 5 & tempMoney[1] > 0){
            tempMoney[1] = tempMoney[1] - 1;
            tempChange[1] = tempChange[1] + 1;
            toDispense = toDispense - 5;
        }
        while(toDispense >= 1 & tempMoney[0] > 0){
            tempMoney[0] = tempMoney[0] - 1;
            tempChange[0] = tempChange[0] + 1;
            toDispense = toDispense - 1;
        }

        if(toDispense == 0){
            change = tempChange;
            return true;
        }
        else{
            return false;
        }
    }

    public String dispenseChange() {
        String text = "Change: ";

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

    public String collectMoney() {
        String text = "";
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (this.money[i] == 0)
                count++;
        }

        if (count == 9) {
            text = "No money to collect.";
        } else {
            for (int i = 0; i < 9; i++) {
                this.money[i] = 0;
            }
            text = "All money in the vending machine collected.";
        }

        return text;
    }

    public String restockingMoney(int money, int count) {
        String text = "Error in restocking. ";
        switch (money) {
            case 1:
                this.money[0] = this.money[0] + count;
                text = "Restocked " + count + " pcs. of 1-peso.\nTotal pcs. in machine: " + this.money[0] + "pcs.";
                break;
            case 5:
                this.money[1] = this.money[1] + count;
                text = "Restocked " + count + " pcs. of 5-peso.\nTotal pcs. in machine: " + this.money[1] + "pcs.";
                break;
            case 10:
                this.money[2] = this.money[2] + count;
                text = "Restocked " + count + " pcs. of 10-peso.\nTotal pcs. in machine: " + this.money[2] + "pcs.";
                break;
            case 20:
                this.money[3] = this.money[3] + count;
                text = "Restocked " + count + " pcs. of 20-peso. \notal pcs. in machine: " + this.money[3] + "pcs.";
                break;
            case 50:
                this.money[4] = this.money[4] + count;
                text = "Restocked " + count + " pcs. of 50-peso.\nTotal pcs. in machine: " + this.money[4] + "pcs.";
                break;
            case 100:
                this.money[5] = this.money[5] + count;
                text = "Restocked " + count + " pcs. of 100-peso.\nTotal pcs. in machine: " + this.money[5] + "pcs.";
                break;
            case 200:
                this.money[6] = this.money[6] + count;
                text = "Restocked " + count + " pcs. of 200-peso.\nTotal pcs. in machine: " + this.money[6] + "pcs.";
                break;
            case 500:
                this.money[7] = this.money[7] + count;
                text = "Restocked " + count + " pcs. of 500-peso.\nTotal pcs. in machine: " + this.money[7] + "pcs.";
                break;
            case 1000:
                this.money[8] = this.money[8] + count;
                text = "Restocked " + count + " pcs. of 1000-peso.\nTotal pcs. in machine: " + this.money[8] + "pcs.";
                break;
            default:
                text += "Invalid denomination.";
                break;
        }
        return text;
    }

    /*public String collectDenomination(int money, int count) {
        String text = "Error in collecting.";
        switch (money) {
            case 1:
                if (this.money[0] <= count){
                    this.money[0] = this.money[0] - count;
                    text = "Collected " + count + " pcs. of 1-peso.\nTotal: " + count * 1 + " pesos.";
                }
                else if(this.money[0] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 5:
                if (this.money[1] <= count){
                    this.money[1] = this.money[1] - count;
                    text = "Collected " + count + " pcs. of 5-peso.\nTotal: " + count * 5 + " pesos.";
                }
                else if(this.money[1] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 10:
                if (this.money[2] <= count){
                    this.money[2] = this.money[2] - count;
                    text = "Collected " + count + " pcs. of 10-peso.\nTotal: " + count * 10 + " pesos.";
                }
                else if(this.money[2] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 20:
                if (this.money[3] <= count){
                    this.money[3] = this.money[3] - count;
                    text = "Collected " + count + " pcs. of 20-peso.\nTotal: " + count * 20 + " pesos.";
                }
                else if(this.money[3] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 50:
                if (this.money[4] <= count){
                    this.money[4] = this.money[4] - count;
                    text = "Collected " + count + " pcs. of 50-peso.\nTotal: " + count * 50 + " pesos.";
                }
                else if(this.money[4] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 100:
                if (this.money[5] <= count){
                    this.money[5] = this.money[5] - count;
                    text = "Collected " + count + " pcs. of 100-peso.\nTotal: " + count * 100 + " pesos.";
                }
                else if(this.money[5] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 200:
                if (this.money[6] <= count){
                    this.money[6] = this.money[6] - count;
                    text = "Collected " + count + " pcs. of 200-peso.\nTotal: " + count * 200 + " pesos.";
                }
                else if(this.money[6] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 500:
                if (this.money[7] <= count){
                    this.money[7] = this.money[7] - count;
                    text = "Collected " + count + " pcs. of 500-peso.\nTotal: " + count * 500 + " pesos.";
                }
                else if(this.money[7] == 0){
                    text = "Nothing to collect.";
                }
                break;
            case 1000:
                if (this.money[8] <= count){
                    this.money[8] = this.money[8] - count;
                    text = "Collected " + count + " pcs. of 1000-peso.\nTotal: " + count * 1000 + " pesos.";
                }
                else if(this.money[8] == 0){
                    text = "Nothing to collect.";
                }
                break;
        }
        return text;
    } */

    public int getMoney(int i) {
        return this.money[i];
    }

    public int getChange(int i){
        return this.change[i];
    }

    public int getTotalUserMoney() {
        return totalUserMoney;
    }

}

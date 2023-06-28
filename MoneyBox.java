public class MoneyBox{
    private int[] bills = {0, 0, 0, 0, 0, 0};
    private int[] coins = {0, 0, 0, 0};
    private int[] change = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public MoneyBox (){

    }

    public boolean haveChange(int total, int money){
        int toDispense = money - total;
        int[] tempBills = bills;
        int[] tempCoins = coins;
        for (int i = 0; i < 10; i++) change[i] = 0;

        while (toDispense >= 1000 && bills[5] > 0){
            toDispense = toDispense - 1000;
            change[9] = change[9] + 1;
            bills[5] = bills[5] - 1;
        }
        while (toDispense >= 500 && bills[4] > 0){
            toDispense = toDispense - 500;
            change[8] = change[8] + 1;
            bills[4] = bills[4] - 1;
        }
        while (toDispense >= 200 && bills[3] > 0){
            toDispense = toDispense - 200;
            change[7] = change[7] + 1;
            bills[3] = bills[3] - 1;
        }
        while (toDispense >= 100 && bills[2] > 0){
            toDispense = toDispense - 100;
            change[6] = change[6] + 1;
            bills[2] = bills[2] - 1;
        }
        while (toDispense >= 50 && bills[1] > 0){
            toDispense = toDispense - 50;
            change[5] = change[5] + 1;
            bills[1] = bills[1] - 1;
        }
        while (toDispense >= 20 && bills[0] > 0){
            toDispense = toDispense - 20;
            change[4] = change[4] + 1;
            bills[0] = bills[0] - 1;
        }
        while (toDispense >= 20 && coins[3] > 0){
            toDispense = toDispense - 20;
            change[3] = change[3] + 1;
            coins[3] = coins[3] - 1;
        }
        while (toDispense >= 10 && coins[2] > 0){
            toDispense = toDispense - 10;
            change[2] = change[2] + 1;
            coins[2] = coins[2] - 1;
        }
        while (toDispense >= 5 && coins[1] > 0){
            toDispense = toDispense - 5;
            change[1] = change[1] + 1;
            coins[1] = coins[1] - 1;
        }
        while (toDispense >= 1 && coins[0] > 0){
            toDispense = toDispense - 1;
            change[0] = change[0] + 1;
            coins[0] = coins[0] - 1;
        }
     //   for (int i = 0; i < 10; i++) System.out.print(change[i] + " ");
     //   System.out.println("\n" + toDispense);

        if (toDispense == 0) return true;
        else{
            bills = tempBills;
            coins = tempCoins;
            return false;
        }
    }

    public void restockBills(int bill, int count){
        switch (bill){
            case 20:
                bills[0] = bills[0] + count;
                break;
            case 50:
                bills[1] = bills[1] + count;
                break;
            case 100:
                bills[2] = bills[2] + count;
                break;
            case 200:
                bills[3] = bills[3] + count;
                break;
            case 500:
                bills[4] = bills[4] + count;
                break;
            case 1000:
                bills[5] = bills[5] + count;
                break;
        }
    }

    public void restockCoins(int coin, int count){
        switch (coin){
            case 1:
                coins[0] = coins[0] + count;
                break;
            case 5:
                coins[1] = coins[1] + count;
                break;
            case 10:
                coins[2] = coins[2] + count;
                break;
            case 20:
                coins[3] = coins[3] + count;
                break;
        }
    }
}
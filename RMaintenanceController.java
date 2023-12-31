import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RMaintenanceController {
    private RMaintenanceView rmv;
    String itemNamesList[] = { "Coke", "Sprite", "Royal",
            "Diet Coke", "Cheese Burger", "Chicken Burger",
            "Bacon Burger", "Fries", "Sundae" };
    private int denomination, count;

    public RMaintenanceController(RMaintenanceView rmv, Model model) {
        this.rmv = rmv;

        this.rmv.viewInventoryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rmv.foodTextDisplay(rmv.getItemInventory());
            }
        });

        this.rmv.restockItemListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int slotNum = Integer.parseInt(rmv.getItemIndex());
                    int quantity = Integer.parseInt(rmv.getItemQuantity());
                    if (slotNum <= 0 || quantity <= 0){
                        rmv.foodTextDisplay("Invalid input.");
                    }
                    else if (model.getVM().slots[slotNum-1].getNumItems() == 10){
                        rmv.foodTextDisplay("Slot is already full.");
                    }
                    else if (quantity+model.getVM().slots[slotNum-1].getNumItems() > 10){
                        rmv.foodTextDisplay("Restock quantity exceeds slot capacity.");
                    }
                    else{
                        rmv.foodTextDisplay(model.getVM().restockItems(slotNum, quantity));
                        model.getVM().transactions.clearTransactions();
                    }
                } catch (Exception err) {
                    rmv.foodTextDisplay("Invalid input.");
                }       
            }
        });

        this.rmv.changePriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int slotNum = Integer.parseInt(rmv.getItemIndex());
                    int newPrice = Integer.parseInt(rmv.getNewPrice());
                    if (slotNum <= 0 || newPrice < 0){
                        rmv.foodTextDisplay("Invalid input.");
                    }
                    else{
                        rmv.foodTextDisplay(model.getVM().changePrice(slotNum, newPrice));
                    }
                } catch (Exception err) {
                    rmv.foodTextDisplay("Invalid input.");
                }
            }
        });

        this.rmv.showTransactionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rmv.foodTextDisplay(model.getVM().displayTransactions());
            }
        });

        this.rmv.restockMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    denomination = Integer.parseInt(rmv.getDenomination());
                    count = Integer.parseInt(rmv.getMoneyQuantity());
                    if (count <= 0 || denomination <= 0){
                        rmv.moneyTextDisplay("Invalid input.");
                    }
                    else{
                        rmv.moneyTextDisplay(model.getVM().box.restockingMoney(denomination, count));
                    }
                } catch (Exception err) {
                    rmv.moneyTextDisplay("Invalid input.");
                }
            }
        });

        this.rmv.dispAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rmv.moneyTextDisplay("1 peso: " + String.valueOf(model.getVM().box.getMoney(0)) + "pcs.\n" +
                        "5 pesos: " + String.valueOf(model.getVM().box.getMoney(1)) + "pcs.\n" +
                        "10 pesos: " + String.valueOf(model.getVM().box.getMoney(2)) + "pcs.\n" +
                        "20 pesos: " + String.valueOf(model.getVM().box.getMoney(3)) + "pcs.\n" +
                        "50 pesos: " + String.valueOf(model.getVM().box.getMoney(4)) + "pcs.\n" +
                        "100 pesos: " + String.valueOf(model.getVM().box.getMoney(5)) + "pcs.\n" +
                        "200 pesos: " + String.valueOf(model.getVM().box.getMoney(6)) + "pcs.\n" +
                        "500 pesos: " + String.valueOf(model.getVM().box.getMoney(7)) + "pcs.\n" +
                        "1000 pesos: " + String.valueOf(model.getVM().box.getMoney(8)) + "pcs.");
            }
        });

        this.rmv.collectAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rmv.moneyTextDisplay(model.getVM().box.collectMoney());
            }
        });
    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class SMaintenanceController {
    private SMaintenanceView smv;
    private SpecialVendingMachine svm;
    String itemNamesList[] = { "Burger", "Fries", "Sundae", 
                                "Coke", "Diet Coke", "Sprite",
                                "Fried Egg", "Lettuce", "Tomato Slice",
                                "Cheese Slice", "Bacon Strip", "Pickle Slice" };
    private int denomination, count;

    public SMaintenanceController(SMaintenanceView smv, Model model){
        this.smv = smv;
        svm = (SpecialVendingMachine) model.getVM();

        svm.transactions.clearTransactions();

        this.smv.viewInventoryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smv.foodTextDisplay(smv.getItemInventory());
            }
        });

        this.smv.restockItemListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int slotNum = Integer.parseInt(smv.getItemIndex());
                int quantity = Integer.parseInt(smv.getItemQuantity());
                if (slotNum <= 6){
                    smv.foodTextDisplay(svm.restockStandAlones(slotNum, quantity));
                }
                else{
                    smv.foodTextDisplay(svm.restockAddOns(slotNum, quantity));
                }
            }
        });

        this.smv.changePriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int slotNum = Integer.parseInt(smv.getItemIndex());
                int newPrice = Integer.parseInt(smv.getNewPrice());
                smv.foodTextDisplay(svm.changePrice(slotNum, newPrice));
            }
        });

        this.smv.showTransactionsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                smv.foodTextDisplay(svm.displayTransactions());
            }
        });

        this.smv.restockMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                denomination = Integer.parseInt(smv.getDenomination());
                count = Integer.parseInt(smv.getMoneyQuantity());
                smv.moneyTextDisplay(svm.box.restockingMoney(denomination, count));;
            }
        }); 
    
        this.smv.dispAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                smv.moneyTextDisplay("1 peso: "+String.valueOf(svm.box.getMoney(0))+"pcs.\n"+
                                    "5 pesos: "+String.valueOf(svm.box.getMoney(1))+"pcs.\n"+
                                    "10 pesos: "+String.valueOf(svm.box.getMoney(2))+"pcs.\n"+
                                    "20 pesos: "+String.valueOf(svm.box.getMoney(3))+"pcs.\n"+
                                    "50 pesos: "+String.valueOf(svm.box.getMoney(4))+"pcs.\n"+
                                    "100 pesos: "+String.valueOf(svm.box.getMoney(5))+"pcs.\n"+
                                    "200 pesos: "+String.valueOf(svm.box.getMoney(6))+"pcs.\n"+
                                    "500 pesos: "+String.valueOf(svm.box.getMoney(7))+"pcs.\n"+
                                    "1000 pesos: "+String.valueOf(svm.box.getMoney(8))+"pcs.");
            }
        });

        this.smv.collectAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                smv.moneyTextDisplay(svm.box.collectMoney());
            }
        });
    }
}

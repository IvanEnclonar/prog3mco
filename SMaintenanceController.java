import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                try {
                    int slotNum = Integer.parseInt(smv.getItemIndex());
                    int quantity = Integer.parseInt(smv.getItemQuantity());
                    if (slotNum <= 0 || quantity <= 0){
                        smv.foodTextDisplay("Invalid input.");
                    }
                    else{
                        if (slotNum <= 6){
                            smv.foodTextDisplay(svm.restockStandAlones(slotNum, quantity));
                            model.getVM().transactions.clearTransactions();
                        }
                        else if (slotNum <= 12){
                            smv.foodTextDisplay(svm.restockAddOns(slotNum, quantity));
                            model.getVM().transactions.clearTransactions();
                        }
                        else{
                            smv.foodTextDisplay("Invalid input.");
                        }
                    }
                } catch (Exception err) {
                    smv.foodTextDisplay("Invalid input.");
                }  

            }
        });

        this.smv.changePriceListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int slotNum = Integer.parseInt(smv.getItemIndex());
                    int newPrice = Integer.parseInt(smv.getNewPrice());
                    if (slotNum <= 0 || newPrice < 0){
                        smv.foodTextDisplay("Invalid input.");
                    }
                    else{
                        smv.foodTextDisplay(model.getVM().changePrice(slotNum, newPrice));
                    }
                } catch (Exception err) {
                    smv.foodTextDisplay("Invalid input.");
                }
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
                try {
                    denomination = Integer.parseInt(smv.getDenomination());
                    count = Integer.parseInt(smv.getMoneyQuantity());
                    if (count <= 0 || denomination <= 0){
                        smv.moneyTextDisplay("Invalid input.");
                    }
                    else{
                        smv.moneyTextDisplay(model.getVM().box.restockingMoney(denomination, count));
                    }
                } catch (Exception err) {
                    smv.moneyTextDisplay("Invalid input.");
                }
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

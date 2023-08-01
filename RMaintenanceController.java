import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class RMaintenanceController{
    private Model model;
    private RMaintenanceView rmv;
    String itemNamesList[] = { "Coke", "Sprite", "Royal", 
                                "Diet Coke", "Cheese Burger", "Chicken Burger",
                                "Bacon Burger", "Fries", "Sundae" };
    private int denomination, count;

    public RMaintenanceController(RMaintenanceView rmv, Model model){
        this.model = model;
        this.rmv = rmv;

        rmv.viewInventoryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rmv.foodTextDisplay(rmv.getItemInventory());
            }
        });

        rmv.restockItemListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int slotNum = Integer.parseInt(rmv.getItemIndex());
                int quantity = Integer.parseInt(rmv.getItemQuantity());
                rmv.foodTextDisplay(model.getVM().restockItems(slotNum, quantity));
            }
        });

        rmv.restockMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                denomination = Integer.parseInt(rmv.getDenomination());
                count = Integer.parseInt(rmv.getMoneyQuantity());
                rmv.moneyTextDisplay(model.getVM().box.restockingMoney(denomination, count));;
            }
        });
    
        rmv.dispAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                rmv.moneyTextDisplay("1 peso: "+String.valueOf(model.getVM().box.getMoney(0))+"pcs.\n"+
                                    "5 pesos: "+String.valueOf(model.getVM().box.getMoney(1))+"pcs.\n"+
                                    "10 pesos: "+String.valueOf(model.getVM().box.getMoney(2))+"pcs.\n"+
                                    "20 pesos: "+String.valueOf(model.getVM().box.getMoney(3))+"pcs.\n"+
                                    "50 pesos: "+String.valueOf(model.getVM().box.getMoney(4))+"pcs.\n"+
                                    "100 pesos: "+String.valueOf(model.getVM().box.getMoney(5))+"pcs.\n"+
                                    "200 pesos: "+String.valueOf(model.getVM().box.getMoney(6))+"pcs.\n"+
                                    "500 pesos: "+String.valueOf(model.getVM().box.getMoney(7))+"pcs.\n"+
                                    "1000 pesos: "+String.valueOf(model.getVM().box.getMoney(8))+"pcs.");
            }
        });

        rmv.collectAllListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                rmv.moneyTextDisplay(model.getVM().box.collectMoney());
            }
        });

    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularController{
    private RegularView regularView;

    public RegularController(RegularView regularView, Model model){
        this.regularView = regularView;

        this.regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));

        this.regularView.Food0Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[0].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(0)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(0);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[1].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(1)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(1);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[2].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(2)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(2);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[3].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(3)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(3);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[4].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(4)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(4);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[5].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(5)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(5);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[6].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(6)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(6);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food7Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[7].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(7)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(7);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Food8Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() > 0 && model.getVM().box.haveChange(model.getVM().slots[8].checkSlot().getPrice())){
                    regularView.dispenseDisplay(model.getVM().buyItem(8)+"\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                    if(model.getVM().slots[0].getNumItems() == 0){
                        regularView.DisableButton(8);
                    }
                }
                else if(model.getVM().box.getTotalUserMoney() <= 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("Please insert money first.");
                }
                else{
                    regularView.dispenseDisplay("No change available in the machine.\n\n"+model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });

        this.regularView.Money1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(1)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(5)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(10)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(20)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(50)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(100)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(200)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(500)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.Money1kListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.dispenseDisplay("");
                regularView.moneyDisplay(model.getVM().box.insertMoney(1000)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        this.regularView.dispenseMoneyListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getVM().box.getTotalUserMoney() == 0){
                    regularView.dispenseDisplay("");
                    regularView.moneyDisplay("No money to dispense.");
                }
                else{
                    regularView.dispenseDisplay(model.getVM().box.dispenseChange());
                    regularView.moneyDisplay("Dispensing money...\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
                }
            }
        });
    }
}

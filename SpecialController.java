import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialController {
    private SpecialView specialView;

    public SpecialController(SpecialView specialView, Model model) {
        this.specialView = specialView;
        SpecialVendingMachine svm = (SpecialVendingMachine) model.getVM();

        this.specialView.Food0Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(0));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(1));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(2));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(3));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(4));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(5));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(6));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food7Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(7));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food8Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(8));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food9Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(9));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(10));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Food11Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.addToCart(11));
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.Money1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(1) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(5) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(10) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(20) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(50) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(100) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(200) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(500) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.Money1kListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.dispenseDisplay(svm.getCart());
                specialView.moneyDisplay(svm.box.insertMoney(1000) + "\n\nBalance: P" + svm.box.getTotalUserMoney());
            }
        });

        this.specialView.confirmListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.buy());
                specialView.dispenseDisplay(svm.getCart());
            }
        });

        this.specialView.cancelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dispText = svm.box.dispenseChange();
                specialView.moneyDisplay("Balance: P" + svm.box.getTotalUserMoney() + "\n\n" + svm.cancelCart());
                dispText += "\n\n" + svm.getCart();
                specialView.dispenseDisplay(dispText);
            }
        });
    }
}

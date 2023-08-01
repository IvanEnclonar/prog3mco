import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularController{
    private RegularView regularView;
    private Model model;

    public RegularController(RegularView regularView, Model model){
        this.regularView = regularView;
        this.model = model;

        regularView.moneyDisplay("Balance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));

        regularView.Food0Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(0)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(1)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(2)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(3)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food4Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(4)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(5)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food6Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(6)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food7Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(7)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Food8Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().buyItem(8)+"\n\nBalance: P"+String.valueOf(model.getVM().box.getTotalUserMoney()));
            }
        });

        regularView.Money1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(1)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money5Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(5)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money10Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(10)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money20Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(20)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money50Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(50)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money100Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(100)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money200Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(200)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money500Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(500)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });

        regularView.Money1kListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regularView.moneyDisplay(model.getVM().box.insertMoney(1000)+"\n\nBalance: P"+model.getVM().box.getTotalUserMoney());
            }
        });
    }
}

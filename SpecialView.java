import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialView extends JFrame{
    private JButton[] FoodButtons = new JButton[12];
    private JLabel addOns = new JLabel("Add-ons"), 
                    insertMoney = new JLabel("Insert Money");
    private JButton money1, money5, money10,
                    money20, money50, money100,
                    money200, money500, money1k;
    private JTextArea dispense, money;
    private JButton confirmPurchase, cancel;
    private VendingMachine vm;

    public SpecialView(VendingMachine vm){
        super("Special Vending Machine");
        this.vm = vm;
        setSize(630, 1075);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        addFoodButtons();

        add(Box.createRigidArea(new Dimension(600, 10)));
        add(Box.createRigidArea(new Dimension(250, 10)));
        add(addOns);
        add(Box.createRigidArea(new Dimension(250, 10)));
        addOnButtons();

        add(Box.createRigidArea(new Dimension(600, 15)));
        add(Box.createRigidArea(new Dimension(250, 10)));
        add(insertMoney);
        add(Box.createRigidArea(new Dimension(250, 10)));
        MoneyButtons();

        add(Box.createRigidArea(new Dimension(600, 15)));

        Display();

        add(Box.createRigidArea(new Dimension(600, 15)));

        confirmPurchase = new JButton("Confirm purchase");
        confirmPurchase.setPreferredSize(new Dimension(600, 30));
        add(confirmPurchase);
        cancel = new JButton("Cancel purchase");
        cancel.setPreferredSize(new Dimension(600, 30));
        add(cancel);

        setVisible(true);
    }

    public void addFoodButtons(){
        for(int i = 0; i < 6; i++){
            FoodButtons[i] = new JButton("Item is unavailable");
            FoodButtons[i].setPreferredSize(new Dimension(200, 150));
            add(FoodButtons[i]);
        }
    }

    public void addOnButtons(){
        for(int i = 6; i < 12; i++){
            FoodButtons[i] = new JButton("Item is unavailable");
            FoodButtons[i].setPreferredSize(new Dimension(200, 150));
            add(FoodButtons[i]);
        }
    }

    public void MoneyButtons(){
        money1 = new JButton("1");
        money1.setPreferredSize(new Dimension(63, 30));
        add(money1);

        money5 = new JButton("5");
        money5.setPreferredSize(new Dimension(63, 30));
        add(money5);

        money10 = new JButton("10");
        money10.setPreferredSize(new Dimension(63, 30));
        add(money10);

        money20 = new JButton("20");
        money20.setPreferredSize(new Dimension(63, 30));
        add(money20);

        money50 = new JButton("50");
        money50.setPreferredSize(new Dimension(63, 30));
        add(money50);

        money100 = new JButton("100");
        money100.setPreferredSize(new Dimension(63, 30));
        add(money100);

        money200 = new JButton("200");
        money200.setPreferredSize(new Dimension(63, 30));
        add(money200);

        money500 = new JButton("500");
        money500.setPreferredSize(new Dimension(63, 30));
        add(money500);

        money1k = new JButton("1000");
        money1k.setPreferredSize(new Dimension(63, 30));
        add(money1k);
    }

    public void Display(){
        dispense = new JTextArea();
        dispense.setPreferredSize(new Dimension(400, 175));
        add(dispense);

        money = new JTextArea();
        money.setPreferredSize(new Dimension(200, 175));
        add(money);
    }

}
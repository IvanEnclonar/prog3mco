import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SpecialView extends JFrame {
    private JButton[] FoodButtons = new JButton[12];
    private JLabel addOns = new JLabel("Add-ons"),
            insertMoney = new JLabel("Insert Money");
    private JButton money1, money5, money10,
            money20, money50, money100,
            money200, money500, money1k;
    private JTextArea dispense, money;
    private JButton confirmPurchase, cancel;
    private SpecialVendingMachine vm;

    public SpecialView(VendingMachine vm) {
        super("Special Vending Machine");
        this.vm = (SpecialVendingMachine) vm;
        setSize(630, 1025);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        addFoodButtons();

        add(Box.createRigidArea(new Dimension(250, 10)));
        add(addOns);
        add(Box.createRigidArea(new Dimension(250, 10)));
        addOnButtons();

        add(Box.createRigidArea(new Dimension(250, 10)));
        add(insertMoney);
        add(Box.createRigidArea(new Dimension(250, 10)));
        MoneyButtons();

        add(Box.createRigidArea(new Dimension(600, 5)));

        Display();

        add(Box.createRigidArea(new Dimension(600, 5)));

        confirmPurchase = new JButton("Confirm purchase");
        confirmPurchase.setPreferredSize(new Dimension(600, 30));
        add(confirmPurchase);
        cancel = new JButton("Cancel purchase");
        cancel.setPreferredSize(new Dimension(600, 30));
        add(cancel);

        setVisible(true);
    }

    public void addFoodButtons() {
        for (int i = 0; i < 6; i++) {
            if (vm.slots[i].getNumItems() != 0) {
                FoodButtons[i] = new JButton();
                FoodButtons(i);
                FoodButtons[i].setPreferredSize(new Dimension(200, 150));
                add(FoodButtons[i]);
            } else {
                FoodButtons[i] = new JButton(getIcon(i));
                FoodButtons[i].setPreferredSize(new Dimension(200, 150));
                add(FoodButtons[i]);
                FoodButtons[i].setEnabled(false);
            }
        }
    }

    public void addOnButtons() {
        for (int i = 6; i < 12; i++) {
            if (vm.slots[i].getNumItems() != 0) {
                FoodButtons[i] = new JButton();
                FoodButtons(i);
                FoodButtons[i].setPreferredSize(new Dimension(200, 150));
                add(FoodButtons[i]);
            } else {
                FoodButtons[i] = new JButton(getIcon(i));
                FoodButtons[i].setPreferredSize(new Dimension(200, 150));
                add(FoodButtons[i]);
                FoodButtons[i].setEnabled(false);
            }
        }
    }

    public void FoodButtons(int i) {
        Icon icon = null;
        int price = vm.slots[i].checkSlot().getPrice();
        float cal = vm.slots[i].checkSlot().getCalories();
        String string = cal + " cal\nPhp " + price;
        FoodButtons[i].setIcon(getIcon(i));
        FoodButtons[i].setText("<html><center>" + string.replaceAll("\\n", "<br>") + "</html>");
        FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
        FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
    }

    public Icon getIcon(int itemIndex){
        Icon icon = null;
        switch (itemIndex) {
            case 0:
                icon = new ImageIcon(getClass().getResource("icons/burger.png"));
                break;
            case 1:
                icon = new ImageIcon(getClass().getResource("icons/fries.png"));
                break;
            case 2:
                icon = new ImageIcon(getClass().getResource("icons/sundae.png"));
                break;
            case 3:
                icon = new ImageIcon(getClass().getResource("icons/coke.png"));
                break;
            case 4:
                icon = new ImageIcon(getClass().getResource("icons/diet coke.png"));
                break;
            case 5:
                icon = new ImageIcon(getClass().getResource("icons/sprite.png"));
                break;
            case 6:
                icon = new ImageIcon(getClass().getResource("icons/fried egg.png"));
                break;
            case 7:
                icon = new ImageIcon(getClass().getResource("icons/lettuce.png"));
                break;
            case 8:
                icon = new ImageIcon(getClass().getResource("icons/tomato slice.png"));
                break;
            case 9:
                icon = new ImageIcon(getClass().getResource("icons/cheese.png"));
                break;
            case 10:
                icon = new ImageIcon(getClass().getResource("icons/bacon strip.png"));
                break;
            case 11:
                icon = new ImageIcon(getClass().getResource("icons/pickle.png"));
                break;
        }
        return icon;
    }

    public void MoneyButtons() {
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

    public void Display() {
        dispense = new JTextArea();
        dispense.setPreferredSize(new Dimension(400, 175));
        add(dispense);

        money = new JTextArea();
        money.setPreferredSize(new Dimension(200, 175));
        add(money);
    }

    public void Food0Listener(ActionListener actionListener) {
        FoodButtons[0].addActionListener(actionListener);
    }

    public void Food1Listener(ActionListener actionListener) {
        FoodButtons[1].addActionListener(actionListener);
    }

    public void Food2Listener(ActionListener actionListener) {
        FoodButtons[2].addActionListener(actionListener);
    }

    public void Food3Listener(ActionListener actionListener) {
        FoodButtons[3].addActionListener(actionListener);
    }

    public void Food4Listener(ActionListener actionListener) {
        FoodButtons[4].addActionListener(actionListener);
    }

    public void Food5Listener(ActionListener actionListener) {
        FoodButtons[5].addActionListener(actionListener);
    }

    public void Food6Listener(ActionListener actionListener) {
        FoodButtons[6].addActionListener(actionListener);
    }

    public void Food7Listener(ActionListener actionListener) {
        FoodButtons[7].addActionListener(actionListener);
    }

    public void Food8Listener(ActionListener actionListener) {
        FoodButtons[8].addActionListener(actionListener);
    }

    public void Food9Listener(ActionListener actionListener) {
        FoodButtons[9].addActionListener(actionListener);
    }

    public void Food10Listener(ActionListener actionListener) {
        FoodButtons[10].addActionListener(actionListener);
    }

    public void Food11Listener(ActionListener actionListener) {
        FoodButtons[11].addActionListener(actionListener);
    }

    public void Money1Listener(ActionListener actionListener) {
        money1.addActionListener(actionListener);
    }

    public void Money5Listener(ActionListener actionListener) {
        money5.addActionListener(actionListener);
    }

    public void Money10Listener(ActionListener actionListener) {
        money10.addActionListener(actionListener);
    }

    public void Money20Listener(ActionListener actionListener) {
        money20.addActionListener(actionListener);
    }

    public void Money50Listener(ActionListener actionListener) {
        money50.addActionListener(actionListener);
    }

    public void Money100Listener(ActionListener actionListener) {
        money100.addActionListener(actionListener);
    }

    public void Money200Listener(ActionListener actionListener) {
        money200.addActionListener(actionListener);
    }

    public void Money500Listener(ActionListener actionListener) {
        money500.addActionListener(actionListener);
    }

    public void Money1kListener(ActionListener actionListener) {
        money1k.addActionListener(actionListener);
    }

    public void confirmListener(ActionListener actionListener) {
        confirmPurchase.addActionListener(actionListener);
    }

    public void cancelListener(ActionListener actionListener) {
        cancel.addActionListener(actionListener);
    }

    public void dispenseDisplay(String text) {
        this.dispense.setText(text);
    }

    public void moneyDisplay(String text) {
        this.money.setText(text);
    }

    public void DisableButton(int index){
        FoodButtons[index].setEnabled(false);
    }
}
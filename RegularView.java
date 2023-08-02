import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegularView extends JFrame{
    private JButton[] FoodButtons = new JButton[9];
    private JButton money1, money5, money10,
                    money20, money50, money100,
                    money200, money500, money1k, dispenseMoney;
    private JLabel moneyLabel = new JLabel("Insert Money");
    private JTextArea dispense, money;
    private VendingMachine vm;

    public RegularView(VendingMachine vm){
        super("Regular Vending Machine");
        this.vm = vm;
        setSize(630, 1000);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        itemButtons();

        add(Box.createRigidArea(new Dimension(600, 25)));
        add(Box.createRigidArea(new Dimension(250, 10)));
        add(moneyLabel);
        add(Box.createRigidArea(new Dimension(250, 10)));

        MoneyButtons();

        add(Box.createRigidArea(new Dimension(600, 30)));

        Display();

        add(Box.createRigidArea(new Dimension(600, 30)));

        dispenseMoney = new JButton("Dispense Money");
        dispenseMoney.setPreferredSize(new Dimension(600, 30));
        add(dispenseMoney);

        setVisible(true);
    }

    public void itemButtons(){
        for(int i = 0; i < 9; i++){
            if(vm.slots[i].getNumItems() != 0){
                FoodButtons[i] = new JButton();
                FoodButtons(i);
                FoodButtons[i].setPreferredSize(new Dimension(200, 175));
                add(FoodButtons[i]);
            }
            else{
                FoodButtons[i] = new JButton("Item Unavailable");
                FoodButtons[i].setPreferredSize(new Dimension(200, 175));
                add(FoodButtons[i]);
            }
        }
    }

    public void FoodButtons(int i){
        Icon icon = null;
        int price = vm.slots[i].checkSlot().getPrice();
        float cal = vm.slots[i].checkSlot().getCalories();
        String string = cal + " cal\nPhp " + price;
        switch(i){
            case 0:
                icon = new ImageIcon(getClass().getResource("icons/coke.png"));
                break;
            case 1:
                icon = new ImageIcon(getClass().getResource("icons/sprite.png"));
                break;
            case 2:
                string = string +"\nroyal";
                break;
            case 3:
                icon = new ImageIcon(getClass().getResource("icons/diet coke.png"));
                break;
            case 4:
                string = string +"\ncheese burger";
                break;
            case 5:
                string = string +"\nchicken burger";
                break;
            case 6:
                string = string +"\nbacon burger";
                break;
            case 7:
                icon = new ImageIcon(getClass().getResource("icons/fries.png"));
                break;
            case 8:
                icon = new ImageIcon(getClass().getResource("icons/sundae.png"));
                break;
        }
        FoodButtons[i].setIcon(icon);
        FoodButtons[i].setText("<html><center>" + string.replaceAll("\\n", "<br>") + "</html>");
        FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
        FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
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
        dispense.setPreferredSize(new Dimension(400, 200));
        add(dispense);

        money = new JTextArea();
        money.setPreferredSize(new Dimension(200, 200));
        add(money);
    }

    public void Food0Listener(ActionListener actionListener){
        FoodButtons[0].addActionListener(actionListener);
    }

    public void Food1Listener(ActionListener actionListener){
        FoodButtons[1].addActionListener(actionListener);
    }

    public void Food2Listener(ActionListener actionListener){
        FoodButtons[2].addActionListener(actionListener);
    }

    public void Food3Listener(ActionListener actionListener){
        FoodButtons[3].addActionListener(actionListener);
    }

    public void Food4Listener(ActionListener actionListener){
        FoodButtons[4].addActionListener(actionListener);
    }

    public void Food5Listener(ActionListener actionListener){
        FoodButtons[5].addActionListener(actionListener);
    }

    public void Food6Listener(ActionListener actionListener){
        FoodButtons[6].addActionListener(actionListener);
    }

    public void Food7Listener(ActionListener actionListener){
        FoodButtons[7].addActionListener(actionListener);
    }

    public void Food8Listener(ActionListener actionListener){
        FoodButtons[8].addActionListener(actionListener);
    }

    public void Money1Listener(ActionListener actionListener){
        money1.addActionListener(actionListener);
    }

    public void Money5Listener(ActionListener actionListener){
        money5.addActionListener(actionListener);
    }

    public void Money10Listener(ActionListener actionListener){
        money10.addActionListener(actionListener);
    }

    public void Money20Listener(ActionListener actionListener){
        money20.addActionListener(actionListener);
    }

    public void Money50Listener(ActionListener actionListener){
        money50.addActionListener(actionListener);
    }

    public void Money100Listener(ActionListener actionListener){
        money100.addActionListener(actionListener);
    }

    public void Money200Listener(ActionListener actionListener){
        money200.addActionListener(actionListener);
    }

    public void Money500Listener(ActionListener actionListener){
        money500.addActionListener(actionListener);
    }

    public void Money1kListener(ActionListener actionListener){
        money1k.addActionListener(actionListener);
    }

    public void dispenseDisplay(String text){
        this.dispense.setText(text);
    }

    public void moneyDisplay(String text){
        this.money.setText(text);
    }

    public void dispenseMoneyListener(ActionListener actionListener){
        dispenseMoney.addActionListener(actionListener);
    }
}

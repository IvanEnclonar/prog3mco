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
        switch(i){
            case 0:
                int cokePrice = vm.slots[0].checkSlot().getPrice();
                float cokeCal = vm.slots[0].checkSlot().getCalories();
                String cokeString = cokeCal + " cal\nPhp " + cokePrice;
                Icon cokeIcon = new ImageIcon(getClass().getResource("icons/coke.png"));
                FoodButtons[i].setIcon(cokeIcon);
                FoodButtons[i].setText("<html><center>" + cokeString.replaceAll("\\n", "<br>") + "</html>");
                FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
                FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
                break;
            case 1:
                int spritePrice = vm.slots[1].checkSlot().getPrice();
                float spriteCal = vm.slots[1].checkSlot().getCalories();
                String spriteString = spriteCal + " cal\nPhp " + spritePrice;
                Icon spriteIcon = new ImageIcon(getClass().getResource("icons/sprite.png"));
                FoodButtons[i].setIcon(spriteIcon);
                FoodButtons[i].setText("<html><center>" + spriteString.replaceAll("\\n", "<br>") + "</html>");
                FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
                FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
                break;
            case 2:
                int royalPrice = vm.slots[2].checkSlot().getPrice();
                float royalCal = vm.slots[2].checkSlot().getCalories();
                String royalString = royalCal + " cal\nPhp " + royalPrice;
                FoodButtons[i].setText("<html><center>" + royalString.replaceAll("\\n", "<br>") + "</html>");
                break;
            case 3:
                int dietCokePrice = vm.slots[3].checkSlot().getPrice();
                float dietCokeCal = vm.slots[3].checkSlot().getCalories();
                String dietCokeString = dietCokeCal + " cal\nPhp " + dietCokePrice;
                Icon dietCokeIcon = new ImageIcon(getClass().getResource("icons/diet coke.png"));
                FoodButtons[i].setIcon(dietCokeIcon);
                FoodButtons[i].setText("<html><center>" + dietCokeString.replaceAll("\\n", "<br>") + "</html>");
                FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
                FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
                break;
            case 4:
                int cheeseBurgerPrice = vm.slots[4].checkSlot().getPrice();
                float cheeseBurgerCal = vm.slots[4].checkSlot().getCalories();
                String cheeseBurgerString = cheeseBurgerCal + " cal\nPhp " + cheeseBurgerPrice;
                FoodButtons[i].setText("<html><center>" + cheeseBurgerString.replaceAll("\\n", "<br>") + "</html>");
                break;
            case 5:
                int chickenBurgerPrice = vm.slots[5].checkSlot().getPrice();
                float chickenBurgerCal = vm.slots[5].checkSlot().getCalories();
                String chickenBurgerString = chickenBurgerCal + " cal\nPhp " + chickenBurgerPrice;
                FoodButtons[i].setText("<html><center>" + chickenBurgerString.replaceAll("\\n", "<br>") + "</html>");
                break;
            case 6:
                int baconBurgerPrice = vm.slots[6].checkSlot().getPrice();
                float baconBurgerCal = vm.slots[6].checkSlot().getCalories();
                String baconBurgerString = baconBurgerCal + " cal\nPhp " + baconBurgerPrice;
                FoodButtons[i].setText("<html><center>" + baconBurgerString.replaceAll("\\n", "<br>") + "</html>");
                break;
            case 7:
                int friesPrice = vm.slots[7].checkSlot().getPrice();
                float friesCal = vm.slots[7].checkSlot().getCalories();
                String friesString = friesCal + " cal\nPhp " + friesPrice;
                Icon friesIcon = new ImageIcon(getClass().getResource("icons/fries.png"));
                FoodButtons[i].setIcon(friesIcon);
                FoodButtons[i].setText("<html><center>" + friesString.replaceAll("\\n", "<br>") + "</html>");
                FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
                FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
                break;
            case 8:
                int sundaePrice = vm.slots[8].checkSlot().getPrice();
                float sundaeCal = vm.slots[8].checkSlot().getCalories();
                String sundaeString = sundaeCal + " cal\nPhp " + sundaePrice;
                Icon sundaeIcon = new ImageIcon(getClass().getResource("icons/sundae.png"));
                FoodButtons[i].setIcon(sundaeIcon);
                FoodButtons[i].setText("<html><center>" + sundaeString.replaceAll("\\n", "<br>") + "</html>");
                FoodButtons[i].setHorizontalTextPosition(JButton.CENTER);
                FoodButtons[i].setVerticalTextPosition(JButton.BOTTOM);
                break;
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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RMaintenanceView extends JFrame{
    private JTextField itemIndex, itemQuantity, newPrice, moneyQuantity, denomination;
    private JButton restockItem, changePrice, restockMoney;
    private JButton viewInventory, displayAll, collectAll, showTransactions;
    private JLabel moneyLabel = new JLabel("Money Box Maintenance"), foodLabel = new JLabel("Inventory");
    private JTextArea foodDisplay, moneyDisplay;
    private VendingMachine vm;
    String itemNamesList[] = { "Coke", "Sprite", "Royal", 
                                "Diet Coke", "Cheese Burger", "Chicken Burger",
                                "Bacon Burger", "Fries", "Sundae" };

    public RMaintenanceView(VendingMachine vm){
        super("Maintaining Regular Vending Machine");

        this.vm = vm;

        setSize(630, 900);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        add(Box.createRigidArea(new Dimension(215, 10)));
        add(foodLabel);
        add(Box.createRigidArea(new Dimension(215, 10)));
        foodDisplay = new JTextArea(getItemInventory());
        foodDisplay.setPreferredSize(new Dimension(600, 250));
        add(foodDisplay);

        viewInventory = new JButton("View Inventory");
        viewInventory.setPreferredSize(new Dimension(605, 30));
        add(viewInventory);

        itemIndex = new JTextField("Enter index of item to edit");
        itemIndex.setPreferredSize(new Dimension(605, 30));
        add(itemIndex);
        itemQuantity = new JTextField("Enter quantity to restock");
        itemQuantity.setPreferredSize(new Dimension(400, 30));
        add(itemQuantity);
        restockItem = new JButton("Restock Item");
        restockItem.setPreferredSize(new Dimension(200, 30));
        add(restockItem);
        newPrice = new JTextField("Enter new price");
        newPrice.setPreferredSize(new Dimension(400, 30));
        add(newPrice);
        changePrice = new JButton("Change Price");
        changePrice.setPreferredSize(new Dimension(200, 30));
        add(changePrice);

        add(Box.createRigidArea(new Dimension(600, 40)));
        showTransactions = new JButton("Show All Transactions");
        showTransactions.setPreferredSize(new Dimension(605, 30));
        add(showTransactions);

        add(Box.createRigidArea(new Dimension(600, 40)));
        add(Box.createRigidArea(new Dimension(215, 10)));
        add(moneyLabel);
        add(Box.createRigidArea(new Dimension(215, 10)));

        displayAll = new JButton("Display Quantity of All Denominations");
        displayAll.setPreferredSize(new Dimension(300, 30));
        add(displayAll);
        collectAll = new JButton("Collect All Money");
        collectAll.setPreferredSize(new Dimension(300, 30));
        add(collectAll);

        moneyDisplay = new JTextArea();
        moneyDisplay.setPreferredSize(new Dimension(600, 200));
        add(moneyDisplay);
        denomination = new JTextField("Enter denomination to restock");
        denomination.setPreferredSize(new Dimension(212, 30));
        add(denomination);
        moneyQuantity = new JTextField("Enter quantity to restock");
        moneyQuantity.setPreferredSize(new Dimension(212, 30));
        add(moneyQuantity);
        restockMoney = new JButton("Restock denomination");
        restockMoney.setPreferredSize(new Dimension(175, 30));
        add(restockMoney);

        setVisible(true);
    }

    public void viewInventoryListener(ActionListener actionListener){
        viewInventory.addActionListener(actionListener);
    }

    public void restockItemListener(ActionListener actionListener){
        restockItem.addActionListener(actionListener);
    }

    public void changePriceListener(ActionListener actionListener){
        changePrice.addActionListener(actionListener);
    }

    public void showTransactionsListener(ActionListener actionListener){
        showTransactions.addActionListener(actionListener);
    }

    public void restockMoneyListener(ActionListener actionListener){
        restockMoney.addActionListener(actionListener);
    }

    public void dispAllListener(ActionListener actionListener){
        displayAll.addActionListener(actionListener);
    }

    public void collectAllListener(ActionListener actionListener){
        collectAll.addActionListener(actionListener);
    }

    public String getItemInventory(){
        String text = "";
        int index = 0;
        for (int i = 0; i < 9; i++){
            index = i+1;
            if(vm.slots[i].getNumItems()==0){
                text += "[" +index+ "] " + itemNamesList[i] + ": " + vm.slots[i].getNumItems()+ "pcs.\n";
            }
            else{
                text += "[" +index+ "] " + itemNamesList[i] + ": " + vm.slots[i].getNumItems()+ "pcs. - P" + vm.slots[i].getPrice() + "\n";
            }
        }
        return text;
    }

    public String getItemIndex(){
        return this.itemIndex.getText();
    }

    public String getItemQuantity(){
        return this.itemQuantity.getText();
    }

    public String getNewPrice(){
        return this.newPrice.getText();
    }

    public String getDenomination(){
        return this.denomination.getText();
    }

    public String getMoneyQuantity(){
        return this.moneyQuantity.getText();
    }

    public void foodTextDisplay(String text){
        this.foodDisplay.setText(text);
    }

    public void moneyTextDisplay(String text){
        this.moneyDisplay.setText(text);
    }
}
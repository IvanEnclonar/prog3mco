import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FactoryView extends JFrame{
    private JButton createRVM, createSVM, testVM, maintainVM;
    private JTextField display;

    public FactoryView(){
        super("Vending Machine Factory");
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(Box.createRigidArea(new Dimension(400, 20)));
        
        CreateVMButtons();
        TMButtons();

        add(Box.createRigidArea(new Dimension(400, 20)));

        display = new JTextField(" ");
        display.setPreferredSize(new Dimension(350, 50));
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);
        add(display);

        setVisible(true);
    }

    public void CreateVMButtons(){
        createRVM = new JButton("Create Regular Vending Machine");
        createRVM.setPreferredSize(new Dimension(350, 50));
        add(createRVM);
        createSVM = new JButton("Create Special Vending Machine");
        createSVM.setPreferredSize(new Dimension(350, 50));
        add(createSVM);
    }

    public void TMButtons(){
        testVM = new JButton("Test Vending Machine");
        testVM.setPreferredSize(new Dimension(350, 50));
        add(testVM);
        maintainVM = new JButton("Perform Maintenance on Vending Machine");
        maintainVM.setPreferredSize(new Dimension(350, 50));
        add(maintainVM);
    }

    public void createRVMListener(ActionListener actionListener){
        createRVM.addActionListener(actionListener);
    }

    public void createSVMListener(ActionListener actionListener){
        createSVM.addActionListener(actionListener);
    }

    public void testVMListener(ActionListener actionListener){
        testVM.addActionListener(actionListener);
    }

    public void maintainVMListener(ActionListener actionListener){
        maintainVM.addActionListener(actionListener);
    }

    public void display(String s){
        display.setText(s);
    }
}

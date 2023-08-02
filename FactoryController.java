import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactoryController {
    private FactoryView factoryView;

    public FactoryController(FactoryView factoryView, Model model) {
        this.factoryView = factoryView;

        this.factoryView.createRVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.vmExists()) {
                    if (model.isSpecial()) {
                        factoryView.display("A Special Vending Machine already exists.");
                    } else {
                        factoryView.display("A Regular Vending Machine already exists.");
                    }
                } else if (model.createRegularVM()) {
                    factoryView.display("Regular Vending Machine created.");
                } else {
                    factoryView.display("Error creating vending machine.");

                }
            }
        });

        this.factoryView.createSVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.vmExists()) {
                    if (model.isSpecial()) {
                        factoryView.display("A Special Vending Machine already exists.");
                    } else {
                        factoryView.display("A Regular Vending Machine already exists.");
                    }
                } else if (model.createSpecialVM()) {
                    factoryView.display("Special Vending Machine created.");
                } else {
                    factoryView.display("Error creating vending machine.");

                }
            }
        });

        this.factoryView.testVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.vmExists()) {
                    if (model.isSpecial()) {
                        factoryView.display("Testing Special Vending Machine.");
                        SpecialView svm = new SpecialView(model.getVM());
                        SpecialController svmController = new SpecialController(svm, model);
                        // add special controller here when created
                    } else {
                        factoryView.display("Testing Regular Vending Machine.");
                        RegularView rvm = new RegularView(model.getVM());
                        RegularController rvmController = new RegularController(rvm, model);
                    }
                } else {
                    factoryView.display("No Vending Machine exists.");
                }
            }
        });

        this.factoryView.maintainVMListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.vmExists()) {
                    if (model.isSpecial()) {
                        factoryView.display("Maintaining Special Vending Machine.");
                    } else {
                        factoryView.display("Maintaining Regular Vending Machine.");
                        RMaintenanceView rmv = new RMaintenanceView(model.getVM());
                        RMaintenanceController rmvController = new RMaintenanceController(rmv, model);
                    }
                } else {
                    factoryView.display("No Vending Machine exists.");
                }
            }
        });
    }
}

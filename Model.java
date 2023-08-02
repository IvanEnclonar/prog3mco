/**
 * This class combines the different classes to one model for the GUI
 */
public class Model {
    private VendingMachine vm = null;
    private boolean special;

    /**
     * Constructor for Model
     */
    public Model(){
    }

    /**
     * Creates a regular vending machine
     * 
     * @return true if the vending machine was created, false otherwise
     */
    public boolean createRegularVM() {
        vm = new VendingMachine();
        special = false;
        return true;
    }

    /**
     * Creates a special vending machine
     * 
     * @return true if the vending machine was created, false otherwise
     */
    public boolean createSpecialVM() {
        vm = new SpecialVendingMachine();
        special = true;
        return true;
    }

    /**
     * Checks if a vending machine exists
     * 
     * @return true if the vending machine exists, false otherwise
     */
    public boolean vmExists() {
        if (vm == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if the vending machine is special or regular
     * 
     * @return true if the vending machine is special, false otherwise
     */
    public boolean isSpecial() {
        return special;
    }

    /**
     * Gets the vending machine
     * 
     * @return the existing vending machine
     */
    public VendingMachine getVM() {
        return vm;
    }
}

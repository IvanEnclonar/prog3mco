public class Model {
    private VendingMachine vm = null;
    private boolean special;

    public boolean createRegularVM() {
        vm = new VendingMachine();
        special = false;
        return true;
    }

    public boolean createSpecialVM() {
        vm = new SpecialVendingMachine();
        special = true;
        return true;
    }

    public boolean vmExists() {
        if (vm == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isSpecial() {
        return special;
    }

    public VendingMachine getVM() {
        return vm;
    }
}

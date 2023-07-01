import java.util.Scanner;

/**
 * This class is used to test the Vending Machine class.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        VendingMachine vm = null;
        int choice = 0;

        // Display the main menu
        while (!exit) {
            System.out.println("VENDING MACHINE FACTORY");
            System.out.println("[1] Test Vending Machine");
            System.out.println("[2] Perform Maintenance on Vending Machine");
            // If a vending machine has not been created, display the option to create one
            if (vm == null) {
                System.out.println("[3] Create New Vending Machine");
            }
            System.out.println("[0] Exit");
            System.out.print("Make selection: ");
            choice = sc.nextInt();

            switch (choice) {
                case 3:
                    // If a vending machine has not been created, create one
                    if (vm == null) {
                        vm = new VendingMachine();
                        System.out.println("\nVending Machine Created\n");
                    }
                    break;
                case 1:
                    // If a vending machine has not been created, display an error message
                    if (vm == null) {
                        System.out.println("\nNo Vending Machine Exists\n");
                        break;
                    } else
                        // Otherwise, display the menu
                        vm.menu(sc);
                    break;
                case 2:
                    // If a vending machine has not been created, display an error message
                    if (vm == null) {
                        System.out.println("\nNo Vending Machine Exists\n");
                        break;
                    } else
                        // Otherwise, display the maintenance menu
                        vm.maintenance(sc);
                    break;
                case 0:
                    exit = true;
            }
        }

    }
}

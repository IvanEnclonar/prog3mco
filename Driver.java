import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Create an array of items with different names, prices, and calories
        /*
         * Item items[] = new Item[10];
         * items[0] = new Item("Coke", 50f, 140);
         * items[1] = new Item("Diet Coke", 50.25f, 0);
         * items[2] = new Item("Sprite", 100.25f, 140);
         * items[3] = new Item("Fanta", 100f, 140);
         * items[4] = new Item("Water", 10f, 0);
         * items[5] = new Item("Gatorade", 40.50f, 140);
         * items[6] = new Item("Powerade", 100f, 140);
         * items[7] = new Item("Coke", 50f, 140);
         * items[8] = new Item("Coke", 50f, 140);
         * items[9] = new Item("Powerade", 100f, 140);
         * 
         * VendingMachine vm = new VendingMachine(items, 10);
         * vm.menu();
         */

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        VendingMachine vm = null;
        int choice = 0;

        while (!exit) {
            System.out.println("VENDING MACHINE FACTORY");
            System.out.println("[1] Test Vending Machine");
            System.out.println("[2] Perform Maintenance on Vending Machine");
            if (vm == null) {
                System.out.println("[3] Create New Vending Machine");
            }
            System.out.println("[0] Exit");
            System.out.print("Make selection: ");
            choice = sc.nextInt();

            switch (choice) {
                case 3:
                    if (vm == null) {
                        vm = new VendingMachine();
                        System.out.println("\nVending Machine Created\n");

                    }
                    break;
                case 1:
                    if (vm == null) {
                        System.out.println("\nNo Vending Machine Exists\n");
                        break;
                    } else
                        vm.menu(sc);
                    break;
                case 2:
                    if (vm == null) {
                        System.out.println("\nNo Vending Machine Exists\n");
                        break;
                    } else
                        vm.maintenance(sc);
                    break;
                case 0:
                    exit = true;
            }
        }

    }
}

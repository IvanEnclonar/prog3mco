public class Driver {
    public static void main(String[] args) {
        // Create an array of items with different names, prices, and calories
        Item items[] = new Item[10];
        items[0] = new Item("Coke", 1.25f, 140);
        items[1] = new Item("Diet Coke", 1.25f, 0);
        items[2] = new Item("Sprite", 1.25f, 140);
        items[3] = new Item("Fanta", 1.25f, 140);
        items[4] = new Item("Water", 1.00f, 0);
        items[5] = new Item("Gatorade", 1.50f, 140);
        items[6] = new Item("Powerade", 1.50f, 140);
        items[7] = new Item("Coke", 1.25f, 140);
        items[8] = new Item("Coke", 1.25f, 140);
        items[9] = new Item("Powerade", 1.50f, 140);

        // Create a vending machine with 8 slots
        VendingMachine vm = new VendingMachine(items, 10);
        vm.displayContent();
    }
}

public class Driver {
    public static void main(String[] args) {
        // Create an array of items with different names, prices, and calories
        Item items[] = new Item[10];
        items[0] = new Item("Coke", 50f, 140);
        items[1] = new Item("Diet Coke", 50.25f, 0);
        items[2] = new Item("Sprite", 100.25f, 140);
        items[3] = new Item("Fanta", 100f, 140);
        items[4] = new Item("Water", 10f, 0);
        items[5] = new Item("Gatorade", 40.50f, 140);
        items[6] = new Item("Powerade", 100f, 140);
        items[7] = new Item("Coke", 50f, 140);
        items[8] = new Item("Coke", 50f, 140);
        items[9] = new Item("Powerade", 100f, 140);

        VendingMachine vm = new VendingMachine(items, 10);
        vm.menu();
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // 1. Adding products
        manager.addProduct(new Product("A101", "Laptop", 10, 899.99));
        manager.addProduct(new Product("B202", "Mouse", 50, 25.50));
        manager.addProduct(new Product("C303", "Monitor", 15, 199.00));

        // 2. Demonstrating TreeSet (Natural Sort)
        manager.displayInventory();

        // 3. Demonstrating Undo (Stack)
        manager.undoLastAddition();

        // 4. Demonstrating Queue (Pending Updates)
        manager.addPendingUpdate("Restock A101 +5 units");
        manager.processUpdate();

        // 5. Demonstrating Comparator (Price Sort)
        manager.displayByPrice();

        // 6. Displaying Transaction History (LinkedList)
        manager.displayHistory();
    }
}
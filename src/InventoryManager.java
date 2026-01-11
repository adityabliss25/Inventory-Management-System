import java.util.*;

public class InventoryManager {
    // HashSet for unique SKU management
    private Set<String> skuRegistry = new HashSet<>();

    // TreeSet for sorted product display
    private TreeSet<Product> productCatalog = new TreeSet<>();

    // LinkedList for transaction history
    private LinkedList<String> history = new LinkedList<>();

    // Stack for undo operations
    private Stack<Product> undoStack = new Stack<>();

    // Queue for pending updates
    private Queue<String> updateQueue = new LinkedList<>();

    public void addProduct(Product p) {
        if (skuRegistry.contains(p.getSku())) {
            System.out.println("Error: Product with SKU " + p.getSku() + " already exists.");
            return;
        }
        skuRegistry.add(p.getSku());
        productCatalog.add(p);
        undoStack.push(p);
        history.add("Added: " + p.getName() + " [" + p.getSku() + "]");
        System.out.println("Product added successfully.");
    }

    public void undoLastAddition() {
        if (!undoStack.isEmpty()) {
            Product removed = undoStack.pop();
            skuRegistry.remove(removed.getSku());
            productCatalog.remove(removed);
            history.add("Undo: Removed " + removed.getName());
            System.out.println("Undo successful: Removed " + removed.getName());
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void addPendingUpdate(String updateRequest) {
        updateQueue.add(updateRequest);
        System.out.println("Update request queued.");
    }

    public void processUpdate() {
        if (!updateQueue.isEmpty()) {
            String request = updateQueue.poll();
            history.add("Processed Update: " + request);
            System.out.println("Processed: " + request);
        } else {
            System.out.println("No pending updates.");
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Current Inventory (Sorted by SKU) ---");
        for (Product p : productCatalog) {
            System.out.println(p);
        }
    }

    public void displayHistory() {
        System.out.println("\n--- Transaction History ---");
        history.forEach(System.out::println);
    }

    // Custom sorting by Price using a Comparator
    public void displayByPrice() {
        List<Product> list = new ArrayList<>(productCatalog);
        list.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("\n--- Products Sorted by Price ---");
        list.forEach(System.out::println);
    }
}
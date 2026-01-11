import java.util.Objects;

// Implementing Comparable for natural sorting by SKU
public class Product implements Comparable<Product> {
    private String sku;
    private String name;
    private int quantity;
    private double price;

    public Product(String sku, String name, int quantity, double price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getSku() { return sku; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // Required for HashSet to identify unique SKUs
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    // Natural sorting by SKU
    @Override
    public int compareTo(Product other) {
        return this.sku.compareTo(other.sku);
    }

    @Override
    public String toString() {
        return String.format("SKU: %-10s | Name: %-15s | Qty: %-5d | Price: $%.2f",
                sku, name, quantity, price);
    }
}
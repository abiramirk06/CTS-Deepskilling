import java.util.HashMap;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "ID: " + productId +
               ", Name: " + productName +
               ", Quantity: " + quantity +
               ", Price: " + price;
    }
}

public class InventorySystem {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(int id, int quantity, double price) {
        Product product = inventory.get(id);

        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(int id) {
        inventory.remove(id);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {

    InventorySystem inv = new InventorySystem();

    inv.addProduct(new Product(101, "Laptop", 10, 55000));
    inv.addProduct(new Product(102, "Mouse", 50, 500));
    inv.addProduct(new Product(103, "Keyboard", 30, 1000));

    System.out.println("Initial Inventory:");
    inv.displayInventory();

    inv.updateProduct(102, 60, 550);
    inv.deleteProduct(103);

    System.out.println("\nUpdated Inventory:");
    inv.displayInventory();
}
}

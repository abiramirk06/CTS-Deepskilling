import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category;
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(target)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int result = products[mid].productName.compareToIgnoreCase(target);

            if (result == 0)
                return products[mid];
            else if (result < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Phone", "Electronics")
        };

        String target = "Mouse";

        Product linearResult = linearSearch(products, target);

        if (linearResult != null)
            System.out.println("Linear Search Found: " + linearResult);
        else
            System.out.println("Product Not Found");

        Arrays.sort(products,
                Comparator.comparing(p -> p.productName.toLowerCase()));

        Product binaryResult = binarySearch(products, target);

        if (binaryResult != null)
            System.out.println("Binary Search Found: " + binaryResult);
        else
            System.out.println("Product Not Found");
    }
}
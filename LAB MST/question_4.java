import java.util.HashMap;
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class ProductManager {
    private HashMap<String, Double> products = new HashMap<>();
    public void addProduct(String id, double price) {
        products.put(id, price);
    }
    public void applyDiscount(String id, double percent)
            throws ProductNotFoundException, IllegalArgumentException {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Product ID not found!");
        }
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100!");
        }
        double oldPrice = products.get(id);
        double newPrice = oldPrice - (oldPrice * percent / 100);
        products.put(id, newPrice);
        System.out.println("New price for " + id + ": $" + newPrice);
    }

    public void display() {
        System.out.print("Display: ");
        for (String id : products.keySet()) {
            System.out.print(id + "=$" + products.get(id));
        }
        System.out.println();
    }
}

public class question_4 {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct("P001", 50.0);
        pm.addProduct("P002", 100.0);
        pm.display();
        try {
            System.out.println("Applying 20% discount to P001: ");
            pm.applyDiscount("P001", 20);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("Applying 150% discount to P002: ");
            pm.applyDiscount("P002", 150);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            System.out.println("Applying discount to P999: ");
            pm.applyDiscount("P999", 10);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

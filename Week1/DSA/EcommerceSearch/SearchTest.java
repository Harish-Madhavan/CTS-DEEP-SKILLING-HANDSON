import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class SearchAlgorithms {
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, String targetName) {
        int left = 0;
        int right = sortedProducts.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedProducts[mid].getProductName().compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P101", "Laptop", "Electronics"),
            new Product("P102", "Smartphone", "Electronics"),
            new Product("P103", "Coffee Maker", "Home Appliances"),
            new Product("P104", "Running Shoes", "Footwear"),
            new Product("P105", "Backpack", "Accessories")
        };

        System.out.println("=== Testing Linear Search ===");
        Product result1 = SearchAlgorithms.linearSearch(products, "Running Shoes");
        System.out.println("Search for 'Running Shoes': " + result1);
        Product result2 = SearchAlgorithms.linearSearch(products, "Tablet");
        System.out.println("Search for 'Tablet': " + result2);

        System.out.println("\n=== Testing Binary Search ===");
        Arrays.sort(products);
        System.out.println("Sorted products for binary search:");
        for (Product p : products) {
            System.out.println("  " + p.getProductName() + " (ID: " + p.getProductId() + ")");
        }

        Product result3 = SearchAlgorithms.binarySearch(products, "Running Shoes");
        System.out.println("Search for 'Running Shoes': " + result3);
        Product result4 = SearchAlgorithms.binarySearch(products, "Tablet");
        System.out.println("Search for 'Tablet': " + result4);
    }
}

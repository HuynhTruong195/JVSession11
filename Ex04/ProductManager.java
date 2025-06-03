package Ex04;

import java.util.*;
import java.util.stream.Collectors;

public class ProductManager {
    private static Map<Integer, Product> products = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Products");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    filterProducts();
                    break;
                case 6:
                    totalValue();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //thêm
    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (products.containsKey(id)) {
            System.out.println("Product ID already exists.");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        products.put(id, new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    //sửa
    private static void editProduct() {
        System.out.print("Enter Product ID to edit: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (!products.containsKey(id)) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter New Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product p = products.get(id);
        p.setName(name);
        p.setPrice(price);
        System.out.println("Product updated.");
    }

    //xóa
    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (products.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }
//hiển thị
    private static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("Current Products:");
        products.values().forEach(display -> display.display());
    }
//lọc
    private static void filterProducts() {
        List<Product> filtered = products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No products with price > 100.");
        } else {
            System.out.println("Filtered Products (Price > 100):");
            filtered.forEach(System.out::println);
        }
    }
//tổng
    private static void totalValue() {
        double total = products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("Total value of products: " + total);
    }
}

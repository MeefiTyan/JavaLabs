package org.example;

public class ProductSearch {
    public static boolean searchProducts(String query, Product... products) {
        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(query) || product.getCategory().getName().equalsIgnoreCase(query)) {
                System.out.println(product);
                found = true;
            }
        }
        return found;
    }
}

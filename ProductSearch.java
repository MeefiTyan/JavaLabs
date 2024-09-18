package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch {
    public static List<Product> searchProducts(String query, Product... products) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(query) || product.getCategory().getName().equalsIgnoreCase(query)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}


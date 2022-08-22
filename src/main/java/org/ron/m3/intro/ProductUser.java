package org.ron.m3.intro;

import org.ron.m3.examples.Product;
import org.ron.m3.examples.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductUser {

    private List<Product> products = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        ProductUser productUser = new ProductUser();
        productUser.readFromDB();
        productUser.showProducts();
//        productUser.markUpProducts(1.3);
//        productUser.showProducts();
//        productUser.testProducts();
//
//        System.out.println();
//        for (int i = 0; i < 4; i++) {
//            Vehicle v = productUser.getUserInput(i);
//            productUser.respondToUser(v);
//        }
    }

    private Vehicle getUserInput(int i) {
        // Scanner ...

        if (i == 0) {
            return new Vehicle("Ford", "fiesta", 4, "blue");
        } else if (i == 1) {
            return new Vehicle("Ford", "fiesta", 4, "red");
        } else if (i == 2) {
            return vehicles.get(0);
        } else {
            return vehicles.get(1);
        }
    }

    private void respondToUser(Vehicle v) {
        System.out.println("DB contains your vehicle? " + vehicles.contains(v));
    }

    private void testProducts() {
        System.out.println("\ntestProducts()");
        StaticsIntro.testEquality("product3 & product4", products.get(3), products.get(4));
        StaticsIntro.testEquality("product1 & product2", products.get(1), products.get(2));
        StaticsIntro.testEquality("product1 & vehicle3", products.get(1), vehicles.get(3));
        StaticsIntro.testEquality("product1 & null", products.get(1), null);

        StaticsIntro.testEquality("vehicle1 & vehicle2", vehicles.get(1), vehicles.get(2));
        StaticsIntro.testEquality("vehicle3 & vehicle2", vehicles.get(3), vehicles.get(2));
        StaticsIntro.testEquality("vehicle3 & vehicle3", vehicles.get(3), vehicles.get(3));
    }

    private void showProducts() {
        System.out.println();
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Product" + i + ": " + products.get(i));
        }
    }

    private void markUpProducts(double increase) {
        for (Product product : products) {
            product.setRRP(product.getRRP() * increase);
        }
    }

    private void readFromDB() {

        // pretend objs are read in from DB

        products.add(new Product(1234, "widget", 9.99, LocalDate.of(2019, 3, 2)));
        products.add(new Product(1234, "widget", 9.99, LocalDate.of(2019, 2, 2)));
        products.add(new Product(1235, "thingy", 19.99));
        products.add(new Product(1236, "stuff", 29.99));
        products.add(new Product(1236, "stuff", 29.99));

        vehicles.add(new Vehicle("Tesla", "model 3", 4, "white"));
        vehicles.add(new Vehicle("Ford", "fiesta", 4, "blue"));
        vehicles.add(new Vehicle("VW", "Beetle", 4, "orange"));
        vehicles.add(new Vehicle("VW", "Beetle", 4, "orange"));
    }
}

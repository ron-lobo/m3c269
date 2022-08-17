package org.ron.m3.intro;

import org.ron.m3.examples.Product;
import org.ron.m3.examples.Vehicle;

import java.time.LocalDate;

public class ProductUser {

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle vehicle3;

    public static void main(String[] args) {
        ProductUser productUser = new ProductUser();
        productUser.setUpProducts();
        productUser.showProducts();
        productUser.markUpProducts(1.3);
        productUser.showProducts();
        productUser.testProducts();
    }

    private void testProducts() {
        System.out.println("\ntestProducts()");
        StaticsIntro.testEquality("product3 & product4", product3, product4);
        StaticsIntro.testEquality("product1 & product2", product1, product2);
        StaticsIntro.testEquality("product1 & vehicle3", product1, vehicle3);
        StaticsIntro.testEquality("product1 & null", product1, null);

        StaticsIntro.testEquality("vehicle1 & vehicle2", vehicle1, vehicle2);
        StaticsIntro.testEquality("vehicle3 & vehicle2", vehicle3, vehicle2);
        StaticsIntro.testEquality("vehicle3 & vehicle3", vehicle3, vehicle3);
    }

    private void showProducts() {
        System.out.println();
        product1.showProduct("Product1");
        product2.showProduct("Product2");
        product3.showProduct("Product3");
        product4.showProduct("Product4");
    }

    private void markUpProducts(double increase) {
        product1.setRRP(product1.getRRP() * increase);
        product2.setRRP(product2.getRRP() * increase);
        product3.setRRP(product3.getRRP() * increase);
        product4.setRRP(product4.getRRP() * increase);
    }

    private void setUpProducts() {
        product1 = new Product(1234, "widget", 9.99, LocalDate.of(2019, 2, 2));
        product2 = new Product(1235, "thingy", 19.99);
        product3 = new Product(1236, "stuff", 29.99);
        product4 = new Product(1236, "stuff", 29.99);

        vehicle1 = new Vehicle("Ford", "fiesta", 4, "blue");
        vehicle2 = new Vehicle("VW", "Beetle", 4, "orange");
        vehicle3 = new Vehicle("VW", "Beetle", 4, "orange");
    }
}

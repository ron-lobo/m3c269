package org.ron.m3.intro;

import org.ron.m3.examples.Product;

import java.time.LocalDate;

public class ProductUser {

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

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
        testEquality("1 & 2", product1, product2);
        testEquality("3 & 4", product3, product4);
    }

    private void testEquality(String text, Product p1, Product p2) {
        System.out.println("comparing: " +  text);
        System.out.println("equals() method: " + (p1.equals(p2) ? "same" : "different"));

        if (p1 == p2) {
            System.out.println("== operator:     same");
        } else {
            System.out.println("== operator:     different");
        }
    }

    private void showProducts() {
        System.out.println();
        product1.showProduct("Product1");
        product2.showProduct("Product2");
        product3.showProduct("Product3");
        product4.showProduct("Product4");
    }

    private  void markUpProducts(double increase) {
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
    }
}

package org.ron.m3.intro;

import org.ron.m3.examples.Product;

import java.time.LocalDate;

public class ProductUser {

    private Product product1;
    private Product product2;
    private Product product3;

    public static void main(String[] args) {
        ProductUser productUser = new ProductUser();
        productUser.setUpProducts();
        productUser.showProducts();
        productUser.markUpProducts(1.3);
        productUser.showProducts();
    }

    private void showProducts() {
        System.out.println();
        product1.showProduct("Product1");
        product2.showProduct("Product2");
        product3.showProduct("Product3");
    }

    private  void markUpProducts(double increase) {
        product1.setRRP(product1.getRRP() * increase);
        product2.setRRP(product2.getRRP() * increase);
        product3.setRRP(product3.getRRP() * increase);
    }

    private void setUpProducts() {
        product1 = new Product(1234, "widget", 9.99, LocalDate.of(2019, 2, 2));
        product2 = new Product(1235, "thingy", 19.99);
        product3 = new Product(1236, "stuff", 29.99);
    }
}

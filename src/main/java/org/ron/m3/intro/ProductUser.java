package org.ron.m3.intro;

import org.ron.m3.examples.Product;

public class ProductUser {

    private Product product1;
    private Product product2;

    public static void main(String[] args) {
        ProductUser productUser = new ProductUser();
        productUser.setUpProducts();
        productUser.useProducts();
        productUser.showProducts();
    }

    private  void showProducts() {
        System.out.printf("Product1: id=", product1.getId(), product1.getName(), product1.getRRP());
    }

    private  void useProducts() {
        double increase = 1.3;
        product1.setRRP(product1.getRRP() * increase);
        product2.setRRP(product2.getRRP() * increase);
    }

    private void setUpProducts() {
        product1 = new Product();
        product1.setId(1234);
        product1.setName("widget");
        product1.setRRP(9.99);

        product2 = new Product();
        product2.setId(1235);
        product2.setName("thingy");
        this.product2.setRRP(19.99);
    }


}

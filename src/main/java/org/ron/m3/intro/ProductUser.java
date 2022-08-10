package org.ron.m3.intro;

import org.ron.m3.examples.Product;

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
        showProduct("Product1", product1);
        showProduct("Product2", product2);
        showProduct("Product3", product3);
    }

    private void showProduct(String text, Product product) {
        System.out.printf("%s: id=%d, name=%s, rrp=£%.2f %n", text, product.getId(), product.getName(), product.getRRP());
    }

    private  void markUpProducts(double increase) {
        product1.setRRP(product1.getRRP() * increase);
        product2.setRRP(product2.getRRP() * increase);
        product3.setRRP(product3.getRRP() * increase);
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

        product3 = new Product();
        product3.setId(1236);
        product3.setName("stuff");
        this.product3.setRRP(29.99);
    }


}

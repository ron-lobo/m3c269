package org.ron.m3.examples;

//import java.time.LocalDate;

public class Product {

    private final int id;
    private final String name;
//    private LocalDate dateOfManufacture;
    private double rrp;

    public Product(int id, String name, double rrp) {
        this.id = setId(id);
        this.name = name;
        setRRP(rrp);
    }

    public int getId() {
        return id;
    }

    private int setId(int id_) {
        // TODO: ensure no clashes somehow ...
        return id_ % 2 == 0 ? id_ : id_ + 1;
    }

    public String getName() {
        return name;
    }

    public double getRRP() {
        return rrp;
    }

    public void setRRP(double rrp) {
        this.rrp = rrp;
    }
}

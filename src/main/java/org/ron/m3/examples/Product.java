package org.ron.m3.examples;

//import java.time.LocalDate;

public class Product {

    private int id;
    private String name;
//    private LocalDate dateOfManufacture;
    private double rrp;


    public int getId() {
        return id;
    }

    public void setId(int id_) {
        // TODO: ensure no clashes somehow ...
        id = id_ % 2 == 0 ? id_ : id_ + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRRP() {
        return rrp;
    }

    public void setRRP(double rrp) {
        this.rrp = rrp;
    }

}

package org.ron.m3.examples;

import java.time.LocalDate;

public class Product {

    private final int id;
    private final String name;
    private LocalDate dateOfManufacture;
    private double rrp;

    public Product(int id, String name, double rrp) {
        this(id, name, rrp, LocalDate.now());
    }

    public Product(int id, String name, double rrp, LocalDate dateOfManufacture) {
        this.id = setId(id);
        this.name = name;
        setRRP(rrp);
        this.dateOfManufacture = dateOfManufacture;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name=" + name +
                ", dateOfManufacture=" + dateOfManufacture +
                ", rrp=" + rrp +
                "}";
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

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product p)) {
            return false;
        }
        return id == p.id;
    }
}

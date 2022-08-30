package org.ron.m3.examples;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Product {

    private final int id;
    private final String name;
    private LocalDate dateOfManufacture;
    private double rrp;
    private List<String> ingredients;

    public Product(int id, String name, double rrp) {
        this(id, name, rrp, LocalDate.now(), null);
    }

    public Product(int id, String name, double rrp, LocalDate dateOfManufacture) {
        this(id, name, rrp, LocalDate.now(), null);
    }

    public Product(int id, String name, double rrp, LocalDate dateOfManufacture, List<String> ingredients) {
        this.id = setId(id);
        this.name = name;
        setRRP(rrp);
        this.dateOfManufacture = dateOfManufacture;
        this.ingredients = ingredients;
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

    public List<String> getIngredients() {
//        List<String> x = new ArrayList<>();
//        x.addAll(ingredients);
//        return x;
        return Collections.unmodifiableList(ingredients);
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

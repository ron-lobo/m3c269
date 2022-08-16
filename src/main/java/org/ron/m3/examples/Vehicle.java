package org.ron.m3.examples;

import java.util.Objects;

public class Vehicle {

    private final String make;
    private final String model;
    private final int numWheels;
    private String colour;
    private String regPlate;

    public Vehicle(String make, String model, int numWheels, String colour) {
        this(make, model, numWheels, colour, null);
    }

    public Vehicle(String make, String model, int numWheels, String colour, String regPlate) {
        this.make = make;
        this.model = model;
        this.numWheels = numWheels;
        this.colour = colour;
        this.regPlate = regPlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getRegPlate() {
        return regPlate;
    }

    public void setRegPlate(String regPlate) {
        this.regPlate = regPlate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vehicle v)) {
            return false;
        }
        return numWheels == v.numWheels &&
                Objects.equals(regPlate, v.regPlate) &&
                Objects.equals(make, v.make) &&
                Objects.equals(model, v.model) &&
                Objects.equals(colour, v.colour);
    }
}

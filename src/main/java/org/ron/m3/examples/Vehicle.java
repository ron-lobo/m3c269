package org.ron.m3.examples;

public class Vehicle {

    private final String make;
    private final String model;
    private final int numWheels;
    private String colour;

    public Vehicle(String make, String model, int numWheels, String colour) {
        this.make = make;
        this.model = model;
        this.numWheels = numWheels;
        this.colour = colour;
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

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

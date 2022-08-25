package org.ron.m3.examples;

import java.util.Comparator;

public class VehicleSorter implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        int result = v1.getColour().compareTo(v2.getColour());
        if (result == 0) {
            result = v1.getModel().compareTo(v2.getModel());
            if (result == 0) {
                if (v1.getRegPlate() == null) {
                    if (v2.getRegPlate() != null) {
                        result = -1;
                    }
                } else {
                    result = v1.getRegPlate().compareTo(v2.getRegPlate());
                }
            }
        }
        return result;
    }
}

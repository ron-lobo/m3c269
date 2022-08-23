package org.ron.m3.intro;

import org.ron.m3.examples.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

    private ProductUser productUser = new ProductUser();

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.productUser.readFromDB();
        sorting.go();
    }

    private void go() {
        List<String> strings1 = createList("Harry Potter", "Hermione Granger", "Luna Lovegood", "Draco Malfoy");
        List<String> strings2 = createStringList("Jacob", "Edward", "Bella");

        showList("strings1 before", strings1);
        Collections.sort(strings1);
        Collections.reverse(strings1);
        // Collections.shuffle(strings1);
        showList("strings1 after", strings1);
        System.out.println();

        List<Vehicle> vehicles = createList(productUser.getVehicles().get(0),
                productUser.getVehicles().get(1), productUser.getVehicles().get(2), productUser.getVehicles().get(3), productUser.getVehicles().get(4));

        System.out.println("vehicles before sort: " + vehicles);
        Collections.sort(vehicles);
//        Collections.reverse(vehicles);
        System.out.println("vehicles after sort:  " + vehicles);
    }

    public void showList(String text, List<String> strings) {
        System.out.println(text + ": strings = " + strings);
//        for (String s : strings) {
//            System.out.println(s);
//        }
//        System.out.println();
    }

    private List<String> createStringList(String... values) {
        List<String> stringList = new ArrayList<>();
        for (String value : values) {
            stringList.add(value);
        }
        return stringList;
    }

    private <T> List<T> createList(T... values) {
        List<T> stringList = new ArrayList<>();
        for (T value : values) {
            stringList.add(value);
        }
        return stringList;
    }
}

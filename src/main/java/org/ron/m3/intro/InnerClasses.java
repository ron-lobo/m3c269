package org.ron.m3.intro;

import org.ron.m3.examples.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class InnerClasses {

    private Cycle bicycle1 = new Bicycle();
    private Cycle bicycle2 = new Bicycle();
    private List<Cycle> bikes = List.of(bicycle1, bicycle2);

    private List<Airplane> airplanes = new ArrayList<>();
    private Random random = new Random();

    public static void main(String[] args) {
        InnerClasses ic = new InnerClasses();
        ic.go();

        // Airplane a = new Airplane();
        Boat boaty = new Boat();
    }

    private void go() {
        createPlanes();
        for (Airplane a : airplanes) {
            usePlanes(a);
        }

        geometry();
        sortProducts();

        useCycle(bicycle1);
        useCycle(new Bicycle());
        Cycle cycle = new Cycle() {
            public void pedal() {
                System.out.println("pedalling fast");
            }

            public void brake() {
                System.out.println("braking hard");
            }
        };
        useCycle(cycle);
    }

    private void useCycle(Cycle c) {
        System.out.println("about to use bicycle ...");
        c.pedal();
        c.brake();
    }

    private void geometry() {
        class Point3D {
            private int x, y, z;
        }

        Point3D p0 = new Point3D();
        Point3D p1 = new Point3D();

        p0.x = 1;
        p0.y = 2;
        p0.z = -3;
    }

    private void sortProducts() {
        ProductUser productUser = new ProductUser();
        productUser.readFromDB();
        List<Product> products = productUser.getProducts();
        System.out.println("products: " + products);
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getDateOfManufacture().compareTo(p2.getDateOfManufacture());
            }
        });
        System.out.println("products: " + products);
    }

    private void usePlanes(Airplane airplane) {
        System.out.printf("this airplane has %d crew and %d passengers%n", airplane.maxCrew, airplane.maxPassengers);
        airplane.fly();
        airplane.land();
    }

    private void createPlanes() {
        int maxPlanes = random.nextInt(2, 6);
        for (int i = 0; i < maxPlanes; i++) {
            Airplane airplane1 = new Airplane(random.nextInt(1, 3), random.nextInt(5, 300));
            airplanes.add(airplane1);
        }
    }

    private interface Cycle {
        void pedal();

        void brake();
    }

    private class Bicycle implements Cycle {
        public void pedal() {
            System.out.println("pedal()");
        }

        public void brake() {
            System.out.println("brake()");
        }
    }

    public class Airplane {

        private int maxPassengers;
        private int maxCrew;

        public Airplane(int maxPassengers, int maxCrew) {
            this.maxPassengers = maxPassengers;
            this.maxCrew = maxCrew;
        }

        public void fly() {
            System.out.println("taking off ...");
            System.out.println("flying smoothly ...");
        }

        public void land() {
            int index = -1;
            for (int i = 0; i < airplanes.size(); i++) {
                if (this == airplanes.get(i)) {
                    index = i;
                }
            }
            System.out.println("landing plane number " + index);
        }
    }

    public static class Boat {
        public void sail() {
            System.out.println("i am sailing");
        }

        public void dock() {
            System.out.println("waiting by the dock on the bay");
        }
    }
}

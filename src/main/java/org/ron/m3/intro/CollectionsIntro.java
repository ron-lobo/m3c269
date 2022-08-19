package org.ron.m3.intro;

import org.apache.commons.collections4.list.TreeList;
import org.ron.m3.examples.Employee;
import org.ron.m3.examples.Vehicle;

import java.util.*;

public class CollectionsIntro {

    private Random random = new Random();
    private Employee e1 = new Employee("Harry", "13 PD", "123", 1000, "potions");

    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();             // ordered, may contain duplicates
        ci.sets();              // unordered, contain no duplicates
        ci.maps();
    }

    private void maps() {
        System.out.println("\nMaps\n----");

        Map<String, Integer> student2GradeMap = new HashMap<>();
        populateMap(student2GradeMap);
        useMap(student2GradeMap);

//        int harrysGrade = student2GradeMap.get("Harry");
//        System.out.println("HarrysGrade = " + harrysGrade);

        for (Map.Entry<String, Integer> entry : student2GradeMap.entrySet()) {
            System.out.printf("student=%s, grade=%d %n", entry.getKey(), entry.getValue());
        }

        System.out.println();
        hashMapPerformance(1000, 750);
        hashMapPerformance(1000_000, 750_000);

        System.out.println();
        Map<Employee, Vehicle> evMap = createEmpVehicleMap();
        Employee hermi = new Employee("Hermione", "123 The Road", "456", 1000, "spells");
        Employee harry = new Employee("Harry", "13 PD", "123", 1000, "potions");

        System.out.println("Hermi's hashCode=" + hermi.hashCode());
        System.out.println("Harry's hashCode=" + harry.hashCode());
        System.out.println("e1's hashCode   =" + e1.hashCode());
        System.out.println("harry equals() e1 ? " + e1.equals(harry));
        System.out.println("harry    ==    e1 ? " + (e1 == harry));

        Vehicle vehicle = evMap.get(hermi);
        System.out.println("Hermioni's vehicle = " + vehicle);
        System.out.println("e1's vehicle = " + evMap.get(e1));
        System.out.println("Harry's vehicle = " + evMap.get(harry));

    }

    private Map<Employee, Vehicle> createEmpVehicleMap() {
        Map<Employee, Vehicle> employeeVehicleMap = new HashMap<>();
        Vehicle v1 = new Vehicle("Fiat", "500", 4, "white");
        employeeVehicleMap.put(e1, v1);
        employeeVehicleMap.put(new Employee("Hermione", "123 The Road", "456", 1000, "spells"), new Vehicle("Maxi", "Mini", 4, "pink"));
        return employeeVehicleMap;
    }

    private void useMap(Map<String, Integer> student2GradeMap) {
        for (String student : student2GradeMap.keySet()) {
            int grade = student2GradeMap.get(student);
            if (grade < 50) {
                student2GradeMap.put(student, grade * 2);
            }
        }
        student2GradeMap.put("Ron", 110);
    }

    private void populateMap(Map<String, Integer> student2GradeMap) {
        student2GradeMap.put("Harry", 99);
        student2GradeMap.put("Hermione", 100);
        student2GradeMap.put("Ron", 10);
    }

    private void hashMapPerformance(int mapSize, int pos) {
        System.out.println("hash map text: mapSize = " + mapSize);
        Map<Integer, Integer> map = new HashMap<>();

//        System.currentTimeMillis();
        long s0 = System.nanoTime();
        for (int i = 0; i < mapSize; i++) {
            map.put(i, random.nextInt(mapSize));
        }
        long s1 = System.nanoTime();
        Integer value = map.get(pos);
        long s2 = System.nanoTime();
        System.out.println("Value at " + pos + " = " + value);

        System.out.println("Map population time: " + (s1 - s0) / 1000 + " micros");
        System.out.println("return item time   : " + (s2 - s1) / 1000 + " micros");
        System.out.println();
    }

    private void sets() {
        System.out.println("\nSets\n----");

        Set<String> stringSet1 = new HashSet<>();
        Set<String> stringSet2 = new TreeSet<>();

        populateSet(stringSet1);
        populateSet(stringSet2);
        populateSet(stringSet2);
        populateSet(stringSet2);

        showSet("stringSet1", stringSet1);
        showSet("stringSet2", stringSet2);
    }

    private void showSet(String text, Set<String> strings) {
        System.out.println("Set " + text + ": " + strings.size() + " items");
        for (String s : strings) {
            System.out.print(s + ", ");
        }
        System.out.println();
        for (Iterator<String> iter = strings.iterator(); iter.hasNext(); ) {
            String s = iter.next();
            System.out.print(s + ", ");
            if (random.nextDouble() < 0.33) {
                iter.remove();                  // safe way to remove elements while looping/iterating
            }
        }
        System.out.println("   final size: " + strings.size() + " items");
        System.out.println();
    }

    private void populateSet(Set<String> strings) {
        strings.add("hello");
        strings.add("gday");
        strings.add("hi");
        strings.add("goodbye");
        strings.add("farewell");
        strings.add("bye");
    }

    private void lists() {
        System.out.println("\nLists\n-----");

        // ArrayList<String> list1 = new ArrayList<>(); // avoid!

        List<String> list1 = new ArrayList<>();
//        list1.add("hi");
//        list1.add("C269");
        useList("list1", list1);

        List<String> list2 = new TreeList<>();
        list2.add("hello");
        list2.add("wonderful");
        list2.add("world");
        useList("list2", list2);

        List<String> linkedList = new LinkedList<>();
        linkedList.add("goodbye");
        linkedList.add("cruel");
        linkedList.add("world");
        useList("linkedList", linkedList);
    }

    private void useList(String text, List<String> list) {
        String sizeInfo = "Initial size = " + list.size();
        System.out.println("'world' in list? " + list.contains("hello"));
        System.out.printf("simple for loop - %s: ", text);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d:%s, ", i, list.get(i));
        }
        System.out.println();

        if (list.size() > 1) {
            list.remove(1);
        }
        list.add("End Item");
        list.add(0, "start item");

        System.out.printf("Java5 for loop - %s: ", text);
        for (String s : list) {
            System.out.printf("%s, ", s);
//            if (list.size() > 0) {
//                list.remove(0);       // beware!
//            }
        }
        System.out.println();
        System.out.println(sizeInfo);
        System.out.println("final size = " + list.size());
        System.out.println();
    }

    private void arrays() {
        System.out.println("\nArrays\n------");

        int[] values1 = new int[]{9, 0, 1, 2, 5};
        int[] values2 = new int[4];

        values2[2] = 999;
        values2[0] = 777;

        System.out.printf("array values2: length=%d, item[0]=%d %n", values2.length, values2[0]);

        System.out.print("simple for loop - values1: ");
        for (int i = 0; i < values1.length; i++) {
            System.out.printf("%d:%d ", i, values1[i]);
        }

        System.out.print("\nJava5 for loop - values1: ");
        for (int val : values1) {
            System.out.print(val + " ");
        }

        String strings[] = new String[3];
        System.out.print("\nJava5 for loop: strings: ");
        for (String s : strings) {
            System.out.printf("%s ", s);
        }
        System.out.println();
    }
}

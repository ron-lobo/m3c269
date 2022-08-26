package org.ron.m3.changes;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A class containing static utility methods
 */
public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class.getName());
    private static final char SPACE = ' ';
    private static boolean useStreams = true;

    private Utils() {
    }

    public static void main(String[] args) {
        final int items = 10;
        final int minValue = 200;
        final int maxValue = 300;
        setUseStreams(false);
        print("getRandomList() [loop]   ", getRandomList(items, minValue, maxValue));
        print("getRandomMap()  [loop]   ", getRandomMap(items, maxValue));
        setUseStreams(true);
        print("getRandomList() [stream] ", getRandomList(items, minValue, maxValue));
        print("getRandomMap()  [stream] ", getRandomMap(items, maxValue));
    }

    public static boolean getUseStreams() {
        return useStreams;
    }

    public static void setUseStreams(boolean useStreams) {
        Utils.useStreams = useStreams;
    }

    // ----------------------------------------

    // create and populate a list with some random values
    public static List<Integer> getRandomList(int maxItems, int minValue, int maxValue) {
        final int numItems = getRandomInt(0, maxItems);
        logger.fine("creating a random list with " + numItems + " items");
        if (useStreams) {
            return IntStream.iterate(0, i -> i < numItems, i -> i + 1).map(i -> getRandomInt(minValue, maxValue)).boxed().collect(Collectors.toList());
        } else {
            List<Integer> myList = new ArrayList<>();
            for (int i = 0; i < numItems; i++) {
                myList.add(getRandomInt(minValue, maxValue));
            }
            return myList;
        }
    }

    // create and populate a map with some random values
    public static Map<Integer, Integer> getRandomMap(int maxItems, int maxValue) {
        final int numItems = getRandomInt(0, maxItems);
        logger.fine("creating a random map with " + numItems + " items");
        if (useStreams) {
            return IntStream.iterate(0, i -> i < numItems, i -> i + 1).map(i -> getRandomInt(0, maxValue))
                    .boxed().collect(Collectors.toMap(k -> k, v -> getRandomInt(0, maxValue), Math::max));
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numItems; i++) {
                map.put(getRandomInt(0, maxValue), getRandomInt(0, maxValue));
            }
            return map;
        }
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
        // return (int) (Math.random() * (max - min) + 0.5) + min;
    }


    // ----------------------------------------
    // Printing Section
    // TODO: optionally enable logging instead of printing to stdout and stderr

    public static String print(Object o) {
        return print(true, o);
    }

    public static String print(boolean isOk, Object o) {
        String s = o == null ? "" : o.toString();
        if (isOk) System.out.println(s);
//        else System.err.println(s);
        else System.out.println("ERROR: " + s);
        return s;
    }

    public static void printStream(String text, Stream<?> stream) {
        print(text, "=", stream.collect(Collectors.toList()));
    }

    public static String print(Object... objects) {
        return printObjects(true, SPACE, objects);
    }

    public static String printerr(Object... objects) {
        return printObjects(false, SPACE, objects);
    }

    public static String printObjects(boolean isOk, char delimiter, Object... objects) {
        if (useStreams) {
//            return print(isOk, String.join(delimiter, objects);
            return print(isOk, Arrays.stream(objects).filter(Objects::nonNull).map(Object::toString)
                    .collect(Collectors.joining(String.valueOf(delimiter))));
        } else {
            StringBuilder sb = new StringBuilder();
            for (Object o : objects) {
                if (o != null) {
                    if (sb.length() > 0) {
                        sb.append(delimiter);
                    }
                    sb.append(o);
                }
            }
            return print(isOk, sb);
        }
    }

    public static void printMethod(String method) {
        String underline = method.replaceAll(".", "-");
        printObjects(true, '\n', "", method, underline);
    }
}

package org.ron.m3.changes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.ron.m3.changes.Utils.*;

public class Java8Streams {

    public static void main(String[] args) {
        printMethod("Features Introduced in Java 8: Streams");
        Java8Streams j8 = new Java8Streams();
        j8.quickIntroToStreams();
        j8.whyDoWeNeedStreams();
        j8.creatingStreams();
        j8.convertingStreams();
        j8.intermediateOperations();
        j8.terminalOperations();
    }


    private void quickIntroToStreams() {
        printMethod("quickIntroToStreams");

        final int MAX = 950;
        List<Integer> myList = getRandomList(100, 500, 1000);


        // get a sequential stream
        Stream<Integer> stream = myList.stream();

        // filter the stream
        Stream<Integer> filteredStream = stream.filter(p -> p > MAX);

        // sort the stream
        Stream<Integer> sortedStream = filteredStream.sorted();

        // print out the values
        sortedStream.forEach(p -> print("High Numbers A: ", p));
        print();


        // all in one line   (compare with Java 7)
        myList.stream().filter(p -> p > MAX).sorted().forEach(p -> print("High Numbers B: ", p));
        print();
    }


    private void whyDoWeNeedStreams() {
        printMethod("whyDoWeNeedStreams");

        List<Integer> myList = getRandomList(1000, -500, 500);

        // Solve this problem: get the sum of all positive values in a list

        // prior to Java 8
        int sum = 0;
        for (int i : myList) {
            if (i > 0) {
                sum += i;
            }
        }
        print("(loop) sum =", sum);


        // The Java 8+ way:
        int streamSum = myList.stream().filter(p -> p > 0).mapToInt(i -> i).sum();
        print("streamSum =", streamSum);


        // This can be parallelized very easily:
        int parallelStreamSum = myList.parallelStream().filter(p -> p > 0).mapToInt(i -> i).sum();
        print("parallelStreamSum =", parallelStreamSum);
    }


    private void creatingStreams() {
        printMethod("creatingStreams");

        // use static of() method in interface Stream
        Stream<Integer> stream = Stream.of(1, 2, 3, 1, 2, 3);

        // creating Sequential and Parallel streams from collections
        List<Integer> myList = getRandomList(10, -10, 10);
        Stream<Integer> sequentialStream = myList.stream();
        Stream<Integer> parallelStream = myList.parallelStream();

        // creating streams from Strings
        IntStream intStreamFromString = "abc".chars();  // Java 9

        // creating streams from Arrays
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4});
        Stream<Integer> integerStream = Arrays.stream(new Integer[]{1, 2, 3, 4});
        Stream<Java8Streams> j8Stream = Arrays.stream(new Java8Streams[]{});

        // Stream.iterate()
        IntStream stream1 = IntStream.iterate(0, i -> i + 1);
        IntStream stream2 = IntStream.iterate(0, i -> i < 10, i -> i + 1);
        Stream<Integer> strStream3 = Stream.iterate(123, i -> i + 1);
        Stream<String> strStream4 = Stream.iterate("23", p -> Integer.parseInt(p) < 100, i -> String.valueOf(Integer.parseInt(i) + 1));

        // Stream.generate()
        Stream<String> endlessStream = Stream.generate(() -> "abc");

        // Stream.range()
        IntStream stream3 = IntStream.range(0, 10);
    }


    private void convertingStreams() {
        printMethod("convertingStreams");

        // use collect() to convert a stream to a collection (Set, List or Map)

        Stream<Integer> integerStream = Stream.of(4, 3, 2, 1, 2, 3, 4, 1, 2, 3, 1);
        Set<Integer> integerSet = integerStream.collect(Collectors.toSet());
        print("integerStream: set =", integerSet.toString());

        integerStream = Stream.of(4, 3, 2, 1, 2, 3, 4, 1, 2, 3, 1); // stream was closed - have to create a new one
        print("integerStream: list =", integerStream.collect(Collectors.toList()));

        integerStream = Stream.of(9, 3, 5, 1, 13, 2);
        Map<Integer, Integer> intMap = integerStream.collect(Collectors.toMap(k -> k, v -> v * v));
        print("integerStream: map =", intMap);

        // Convert Stream to an Array
        integerStream = Stream.of(1, 2, 3, 4);
        Integer[] intArray = integerStream.toArray(Integer[]::new);
        print("intStream1: array =", Arrays.toString(intArray));
    }


    private void intermediateOperations() {
        printMethod("intermediateOperations");
        List<Integer> list = getRandomList(20, -100, 100);
        print("list =", list, "; size =", list.size());

        // filter()
        Stream<Integer> positives = list.stream().filter(p -> p > 0);    // keep only positive numbers
        Utils.printStream("filter: positives", positives);

        // limit()
        Stream<Integer> limit = list.stream().limit(3);   // "short-circuiting" intermediate operation
        Utils.printStream("limit", limit);

        // map()
        Stream<String> words = Stream.of("m3", "Finest", "Bestest", "Awesomest", "training");
        Stream<String> upperCaseStream = words.map(String::toUpperCase);       // s -> s.toUpperCase()
        Utils.printStream("map: upperCase", upperCaseStream);

        // sorted()
        Stream<Integer> stream2 = list.stream();
        Stream<Integer> sortedInts = stream2.sorted();
        Utils.printStream("sorted", sortedInts);

        // sorted() using Comparator argument
        Stream<Integer> reverseSortedInts = list.stream().sorted(Comparator.reverseOrder());
        Utils.printStream("reverse sorted", reverseSortedInts);

        // flatMap() - 'flatten' a stream of collections to a simple, flat stream of objects
        Stream<List<String>> wordListsStream = Stream.of(
                List.of("The", "quick", "brown", "fox"),
                List.of("jumps", "over"),
                List.of("the", "lazy", "dog"));
//		Utils.printStream("wordListsStream", wordListsStream);
        Stream<String> wordStream = wordListsStream.flatMap(Collection::stream);
        Utils.printStream("flatMap", wordStream);
    }

    private void terminalOperations() {
        terminalOperations("shortList", Arrays.asList(2, 10, 5, 3, 7, 4));
        terminalOperations("randomList", getRandomList(1000000, -200, 400));
    }

    private /*static*/ int myCompare(int a, int b) {
        return 0;
    }

    private void terminalOperations(String listName, List<Integer> integerList) {

        printMethod("terminalOperations");
        print("listName    =", listName);
        if (integerList.size() < 100) print("integerList =", integerList);
        print();

        // count(), sum()
        print("count   =", integerList.stream().count());
        print("sum     =", integerList.stream().mapToInt(p -> p).sum());
        print();

        // average(), min(), max()
        print("average =", integerList.stream().mapToDouble(p -> p).average());
        print("min     =", integerList.stream().mapToInt(p -> p).min());
        print("max     =", integerList.stream().mapToLong(p -> p).max());
        print();

        print("min     =", integerList.stream().min((a, b) -> a.compareTo(b)));
        print("min     =", integerList.stream().min((a, b) -> Integer.compare(a, b)));
        print("min     =", integerList.stream().min(Integer::compareTo));
        print("min     =", integerList.stream().min(Integer::compare));
        print("min     =", integerList.stream().min(this::myCompare));
        print("min     =", integerList.stream().min(Comparator.naturalOrder()));
        print("min     =", integerList.stream().min(Comparator.comparingInt(a -> a)));
        print();

        // Optional
        OptionalDouble optionalAverageValue = integerList.stream().mapToInt(p -> p).average();
        if (optionalAverageValue.isPresent()) {
            print("(optional) avg =", optionalAverageValue.getAsDouble());
        }

        Optional<Integer> optionalMinValue = integerList.stream().min(Integer::compare);
        optionalMinValue.ifPresent(i -> print("(optional) min =", i));

        integerList.stream().max(Integer::compareTo).ifPresentOrElse(i -> print("(optional) max =", i), () -> print("empty stream"));

        print("min =", integerList.stream().min(Integer::compare).orElse(Integer.MIN_VALUE));
        print();

        // reduce() - use an associative accumulation function
        integerList.stream().reduce((i, j) -> i + j).ifPresent(s -> print("reduce: sum     =", s));
        integerList.stream().reduce((i, j) -> i * j).ifPresent(p -> print("reduce: product =", p));

        // forEach() - print out odd numbers
        Stream<Integer> intStream = integerList.stream();
        intStream.filter(i -> i % 2 == 1).limit(10).forEach(i -> print("forEach: odd =", i));


        // short-circuiting operations

        // match - match any, none or all items in the stream
        print("match: does the stream contain 10?    ", integerList.stream().anyMatch(i -> i == 10));
        print("match: does the stream not contain 10?", integerList.stream().noneMatch(i -> i == 10));
        print("match: are all elements positive?     ", integerList.stream().allMatch(i -> i > 0));

        // findFirst
        Optional<Integer> optionalFirstOdd = integerList.stream().filter(i -> i % 2 == 1).findFirst();
        optionalFirstOdd.ifPresentOrElse(i -> print("findFirst: first odd number =", i), () -> print("no odds found"));

        // findAny
        Optional<Integer> optionalFirstAny = integerList.stream().filter(i -> i % 2 == 1).findAny();
        optionalFirstAny.ifPresent(integer -> print("findAny: an odd number      =", integer));
    }
}

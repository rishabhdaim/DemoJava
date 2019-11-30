package vavr;

import io.vavr.collection.Stream;

public class StreamExample {
    public static void main(String[] args) {
        Stream<String> s = Stream.of("A", "b", "c");
        s.map(String::toLowerCase).take(2).forEach(System.out::println);
        s.map(String::toUpperCase).forEach(System.out::println);
    }
}

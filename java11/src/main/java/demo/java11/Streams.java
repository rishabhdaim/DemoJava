package demo.java11;

import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        Stream.of("a", "b", "c", "", "e").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);
        Stream.of("a", "b", "c", "", "e").dropWhile(String::isEmpty).forEach(System.out::print);
        Stream.of("a", "b", "c", "", "e").takeWhile(s -> !s.isEmpty()).dropWhile(String::isEmpty).forEach(System.out::print);
        Stream.of("a", "b", "c", "", "e").takeWhile(s -> !s.isEmpty()).dropWhile(s -> !s.isEmpty()).forEach(System.out::print);

        Stream.iterate(1, i -> i <=20, i -> i * 3).forEach(System.out::print);
    }
}

package demo.java17.vavr;

import io.vavr.control.Try;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListFilter {
    public static void main(String[] args) {
        List<String> users = List.of("Rishabh", "Daim", "Kumar", "Ankit", "Umesh", "Aryan", "Deep");

        // java approach
        var collect = users.stream().filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(collect);

        // java slang
        var col = io.vavr.collection.List.ofAll(users).filter( u -> Try.of(() -> Objects.nonNull(u)).getOrElse(false));
        System.out.println(col);
    }
}

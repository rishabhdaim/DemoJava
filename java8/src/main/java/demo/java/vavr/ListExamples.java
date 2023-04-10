package demo.java.vavr;

import io.vavr.collection.List;

public class ListExamples {
    public static void main(String[] args) {
        List<String> l = List.of("Rishabh", "Ankit", "Munna");
        System.out.println(l);
        System.out.println(l.append("aryan"));
        System.out.println(l.prepend("aryan"));

    }
}

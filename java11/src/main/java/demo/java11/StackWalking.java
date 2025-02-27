package demo.java11;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;
import static java.lang.StackWalker.Option.SHOW_HIDDEN_FRAMES;

public class StackWalking {
    public static void main(String[] args) {
        one();
    }

    private static void one() {
        two();
    }

    private static void two() {
        StackWalker walker =  StackWalker.getInstance(Set.of(RETAIN_CLASS_REFERENCE, SHOW_HIDDEN_FRAMES), 10);
        System.out.println(walker.getCallerClass());
        walker.forEach(System.out::println);

        List<StackWalker.StackFrame> frameList = walker.walk(frames -> frames.collect(Collectors.toList()));
        long c = walker.walk(Stream::count);
        System.out.println(c);
    }
}

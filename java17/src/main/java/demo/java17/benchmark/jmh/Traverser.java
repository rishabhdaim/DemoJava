package demo.java17.benchmark.jmh;

import com.google.common.collect.TreeTraverser;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@BenchmarkMode(Mode.AverageTime)
@Fork(2)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class Traverser {

    @NotNull
    public static <T> FluentIterable<T> preOrderTraversal(final T root, final @NotNull Function<T, Iterable<? extends T>> childExtractor) {

        Objects.requireNonNull(childExtractor, "Children extractor function must not be null");

        if (root == null) {
            return FluentIterable.empty();
        }

        return FluentIterable.of(new Iterable<>() {
            @Override
            public @NotNull Iterator<T> iterator() {
                return UnmodifiableIterator.unmodifiableIterator(new PreOrderIterator<>(root, childExtractor));
            }
        });
    }

    private static final class PreOrderIterator<T> implements Iterator<T> {

        private final Deque<Iterator<? extends T>> stack;
        private final Function<T, Iterable<? extends T>> childExtractor;

        public PreOrderIterator(final T root, final Function<T, Iterable<? extends T>> childExtractor) {
            this.childExtractor = childExtractor;
            this.stack = new ArrayDeque<>();
            // add first element during initialization
            stack.addLast(Collections.singletonList(root).iterator());
        }

        @Override
        public boolean hasNext() {
            // Remove any empty iterators from the top of the stack
            while (!stack.isEmpty() && !stack.peek().hasNext()) {
                stack.pop();
            }
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes in the tree");
            }

            // Get next element from the current iterator
            T current = stack.peek().next();

            // Push the iterator for children onto the stack
            // Children added later will be processed first in pre-order traversal
            Iterator<? extends T> childIter = childExtractor.apply(current).iterator();
            if (childIter.hasNext()) {
                stack.push(childIter);
            }
            return current;
        }
    }

    @NotNull
    public static <T> FluentIterable<T> breadthFirstTraversal(final T root, final @NotNull Function<T, Iterable<? extends T>> childExtractor) {
        Objects.requireNonNull(childExtractor, "Children extractor function must not be null");

        if (root == null) {
            return FluentIterable.empty();
        }

        return FluentIterable.of(new Iterable<>() {
            @Override
            public @NotNull Iterator<T> iterator() {
                return UnmodifiableIterator.unmodifiableIterator(new BreadthFirstIterator<>(root, childExtractor));
            }
        });
    }

    private static final class BreadthFirstIterator<T> implements Iterator<T> {

        private final Deque<T> queue;
        private final Function<T, Iterable<? extends T>> childExtractor;

        public BreadthFirstIterator(final T root, final Function<T, Iterable<? extends T>> childExtractor) {
            this.queue = new ArrayDeque<>();
            this.childExtractor = childExtractor;
            this.queue.add(root);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes in the tree");
            }

            final T current = queue.removeFirst();

            // Add all children to the queue (in order)
            for (T child : childExtractor.apply(current)) {
                // would throw NPE if the child is null
                queue.addLast(child);
            }
            return current;
        }
    }

    // Helper class for testing tree traversal
    private static class Node {
        private final int value;
        private final List<Node> children = new ArrayList<>();

        public Node(int value, Node... children) {
            this.value = value;
            this.children.addAll(Arrays.asList(children));
        }

        public int getValue() {
            return value;
        }

        public Iterable<Node> getChildren() {
            return children;
        }

        public void addChild(Node child) {
            children.add(child);
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }


    @Param({"1", "100", "10000", "1000000"})
    private int count;

    @Benchmark
    public void guavaBFS(Blackhole bh) {

        final Node root = getRoot();

        final TreeTraverser<Node> traverser = new TreeTraverser<>() {
            @Override
            public Iterable<Node> children(Node root) {
                return root.getChildren();
            }
        };

        bh.consume(traverser.breadthFirstTraversal(root).transform(Node::getValue).size());
    }

    @Benchmark
    public void guavaPreOrder(Blackhole bh) {

        final Node root = getRoot();

        final TreeTraverser<Node> traverser = new TreeTraverser<>() {
            @Override
            public Iterable<Node> children(Node root) {
                return root.getChildren();
            }
        };

        bh.consume(traverser.preOrderTraversal(root).transform(Node::getValue).size());
    }

    @Benchmark
    public void oakBFS(Blackhole bh) {

        final Node root = getRoot();


        bh.consume(Traverser.breadthFirstTraversal(root, Node::getChildren)
                .transform(Node::getValue).size());
    }

    @Benchmark
    public void oakPreOrder(Blackhole bh) {

        final Node root = getRoot();


        bh.consume(Traverser.preOrderTraversal(root, Node::getChildren)
                .transform(Node::getValue).size());
    }

    private @NotNull Node getRoot() {
        final Node root = new Node(4);

        List<Node> parents = new ArrayList<>();
        parents.add(root);  // Start with root as the only parent

        int nodesCreated = 0;
        while (nodesCreated < count) {
            List<Node> nextParents = new ArrayList<>();

            // For each current parent
            for (Node parent : parents) {
                // Add up to 10 children (or until we reach count)
                for (int i = 0; i < 10 && nodesCreated < count; i++) {
                    Node child = new Node(nodesCreated + 5);  // Unique value
                    parent.addChild(child);
                    nodesCreated++;

                    // If this is the first child of this parent, it will become a parent in the next round
                    if (i == 0) {
                        nextParents.add(child);
                    }
                }
            }

            // Update parents for the next round
            parents = nextParents;
        }

        return root;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Traverser.class.getSimpleName() + ".*")
                .build();
        new Runner(opt).run();
    }
}

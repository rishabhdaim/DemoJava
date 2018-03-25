/**
 * 
 */
package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author diam
 *
 */
public class Java8Tutorial {
	
	@FunctionalInterface
	interface Formula {
		
		double calculate(int a);
		
		default double sqrt(int a) {
			return Math.sqrt(a);
		}
	}
	
	@FunctionalInterface
	interface Converter<F, T> {
		
		T convert(F from);
	}
	
	@FunctionalInterface
	interface PersonFactory<P extends Person> {
	    
		P create(String firstName, String lastName);
	}

	
	static class Something {
	    String startsWith(String s) {
	        return String.valueOf(s.charAt(0));
	    }
	}
	
	static class Person {
	    String firstName;
	    String lastName;

	    Person() {}

	    Person(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Formula formula = new Formula() {
			
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(4));
		
		// lambda expressions
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		
		System.out.println(names);
		
		Collections.sort(names, (a, b) -> a.compareTo(b));
		System.out.println(names);
		
		// Functional Interfaces
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("1234");
		System.out.println(converted);
		
		// Method and constructor references
		
		converter = Integer::valueOf;
		converted = converter.convert("12");
		System.out.println(converted);
		
		Something something = new Something();
		Converter<String, String> converter2 = something::startsWith;
		String convertedString = converter2.convert("Java");
		System.out.println(convertedString);
		
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("rishu", "daim");
		System.out.println(person.firstName);
		// accessing variables
		
		final int n = 10; // must be implicit final
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + n);
		System.out.println(stringConverter.convert(5));
		
		// build-in functional interfaces
		
		// Predicates
		
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("foo"));
		System.out.println(predicate.negate().test("foo"));
		
		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;
		
		System.out.println(nonNull.test(null));
		System.out.println(isNull.negate().test(Boolean.valueOf(true)));

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		System.out.println(isEmpty.test("foo"));
		System.out.println(isNotEmpty.test("foo"));
		
		// Functions
		
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		System.out.println(backToString.apply("123"));
		
		// suppliers
		
		Supplier<Person> supplier = () -> new Person("rishu", "daim");
		supplier.get(); // gives a person
		
		// Consumers
		Consumer<Person> greeter = p -> System.out.println("Hello! " + p.firstName);
		greeter.accept(supplier.get());
		
		// Comparators
		
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0
		
		// Optionals
		
		Optional<String> optional = Optional.of("bam");

		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
		
		// Streams
		
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		
		// Filters
		stringCollection.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
		
		// Sorted
		stringCollection.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::println);
		
		// Map
		stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		
		// Match
		boolean anyStartsWithA = stringCollection.stream().anyMatch((s) -> s.startsWith("a"));
		System.out.println(anyStartsWithA);      // true

		boolean allStartsWithA = stringCollection.stream().allMatch((s) -> s.startsWith("a"));
		System.out.println(allStartsWithA);      // false

		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
		System.out.println(noneStartsWithZ);      // true
		
		// Count
		long startsWithB = stringCollection.stream().filter((s) -> s.startsWith("b")).count();
		System.out.println(startsWithB);    // 3
		
		// Reduce
		Optional<String> reduced = stringCollection.stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
		reduced.ifPresent(System.out::println);
		
		// Parallel Streams
		final int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		// Sequential Sort
		long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);

		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		// Parallel Sort
		
		values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		t0 = System.nanoTime();
		count = values.parallelStream().sorted().count();
		System.out.println(count);
		t1 = System.nanoTime();

		millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));

		// Map methods
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, val) -> System.out.println(val));
		
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);             // val33

		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false

		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true

		map.computeIfAbsent(3, num -> "bam");
		map.get(3);             // val33
		
		map.remove(3, "val3");
		map.get(3);             // val33

		map.remove(3, "val33");
		map.get(3);
		
		map.getOrDefault(42, "not found");  // not found
		
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		map.get(9); 
	}
}

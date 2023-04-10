/**
 * 
 */
package demo.java.java8.impatient;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Rishabh.Daim
 *
 */
public class StreamUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String contents = new String(Files.readAllBytes(Paths.get("property/DAVINCERS_in.properties")));
			List<String> words = Arrays.asList(contents.split("[\\P{L}+]"));
			
			long count = 0;
			for (String s : words) if (s.length() > 6) count++;
			
			System.out.println(words.size());
			System.out.println(count);
			
			// using streams
			
			count = words.parallelStream().filter(w -> w.length() > 6).count();
			System.out.println(count);
			
			count = words.stream().filter(w -> w.length() > 6).count();
			System.out.println(count);
			
			// stream creation
			createStream(contents);
			// ARM with Stream
			armWithStream();
			// stream transformations
			streamTransformation(words);
			
			// reduction operation
			reductionOperations(words);
			
			// collecting result
			collectingResult(words);
			
			// grouping & partitioning
			groupingResult();
			
			// int stream
			intStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void intStream() {
		IntStream intStream = IntStream.of(1,2,3,4,5,6,7);
		intStream.forEach(System.out::println);
	}

	private static void groupingResult() {
		Map<String, List<Locale>> countryLanguageList = Stream.of(Locale.getAvailableLocales()).parallel().collect(Collectors.groupingBy(Locale::getCountry));
		System.out.println(countryLanguageList);
		
		// partition by
		Map<Boolean, List<Locale>> englishLanguageSet = Stream.of(Locale.getAvailableLocales()).parallel().collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
		System.out.println(englishLanguageSet.get(true));
		
		// group concurrent map to set
		Map<String, Set<Locale>> countryLanguageSet = Stream.of(Locale.getAvailableLocales()).parallel().collect(Collectors.groupingByConcurrent(Locale::getCountry, Collectors.toSet()));
		System.out.println(countryLanguageSet);
		
		// group count
		Map<String, Long> countryLanguageCount = Stream.of(Locale.getAvailableLocales()).parallel().collect(Collectors.groupingByConcurrent(Locale::getCountry, Collectors.counting()));
		System.out.println(countryLanguageCount);
	}

	private static void collectingResult(List<String> words) {
		String[] result = words.parallelStream().toArray(String[]::new);
		System.out.println(Arrays.toString(result));
		
		// hashSet
		HashSet<String> wordSet = words.parallelStream().collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println(wordSet);
		
		// Collection Set
		Set<String> collectorSet = words.parallelStream().collect(Collectors.toSet());
		System.out.println(collectorSet);
		
		// Collector TreeSet
		Set<String> treeSet = words.parallelStream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);
		
		// String concatenation
		String wordStr = words.parallelStream().collect(Collectors.joining(", "));
		System.out.println(wordStr);
		
		// Summary Methods
		IntSummaryStatistics statistics = words.parallelStream().collect(Collectors.summarizingInt(String::length));
		System.out.println("Average : " + statistics.getAverage());
		System.out.println("Sum : " + statistics.getSum());
		System.out.println("Count : " + statistics.getCount());
		System.out.println("Max : " + statistics.getMax());
		System.out.println("Min : " + statistics.getMin());
		
		//Locale Map
		Map<String, String> locales = Stream.of(Locale.getAvailableLocales()).parallel().collect(Collectors.toMap(l -> l.getDisplayLanguage(), l -> l.getDisplayLanguage(l), (existingValue, newValue) -> existingValue));
		System.out.println(locales);
		
		// Country language set
		Map<String, Set<String>> countryLanguageSet = Stream.of(Locale.getAvailableLocales()).parallel().collect(Collectors.toMap(l -> l.getDisplayLanguage(), l -> Collections.singleton(l.getDisplayLanguage()), (a,b) -> {
			Set<String> r = new HashSet<>(a); r.addAll(b); return r;
		}, ConcurrentHashMap::new));
		System.out.println(countryLanguageSet);
	}

	private static void reductionOperations(List<String> words) {
		Integer sum = words.parallelStream().filter(s -> s.length() > 0).map(String::length).reduce(0, (x,y) -> x+y);
		System.out.println("Sum is : " + sum);
		
		// Optional Sum
		Optional<Integer> sumMethodRefererce = words.parallelStream().filter(s -> s.length() > 0).map(String::length).reduce(Integer::sum);
		sumMethodRefererce.ifPresent(System.out::println);
		
		// Map To Int
		int mapToInt = words.parallelStream().mapToInt(String::length).sum();
		System.out.println("mapToInt : " + mapToInt);
		
	}

	private static Stream<Character> characterStream(String s) {
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray()) result.add(c);
		return result.stream();
		}

	private static void streamTransformation(List<String> wordList) {
		Stream<String> lowerCase = wordList.stream().map(String::toLowerCase);
		lowerCase.limit(10).forEach(System.out::println);
		
		Stream<String> upperCase = wordList.stream().map(String::toUpperCase);
		upperCase.limit(10).forEach(System.out::println);
		
		Stream<Character> firstChar = wordList.stream().filter(s -> s.length() > 0).map(s -> s.charAt(0));
		firstChar.limit(20).forEach(System.out::println);
		
		Stream<Stream<Character>> charStream = wordList.stream().filter(s -> s.length() > 0).map(s -> characterStream(s));
		charStream.limit(20).forEach(System.out::println);
		
		// flat Map
		Stream<Character> charFlatStream = wordList.stream().filter(s -> s.length() > 0).flatMap(s -> characterStream(s));
		charFlatStream.limit(20).forEach(System.out::print);
		System.out.println();
		
		// skip
		Stream<Character> concatStream = Stream.concat(characterStream("The Rishabh"), characterStream("Daim"));
		concatStream.skip(4).forEach(System.out::print);
		
		//peek
		Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();
		System.out.println(Arrays.toString(powers));
		
		// distinct
		Stream<String> unique = Stream.of("merrily","merrily","merrily","gently").distinct();
		unique.forEach(System.out::println);
		
		//sorting
		Stream<String> sortedList = wordList.stream().sorted(Comparator.comparing(String::length).reversed());
		sortedList.limit(10).forEach(System.out::println);
		
		//optional usage
		Optional<String> largestString = wordList.stream().max(String::compareToIgnoreCase);
		if (largestString.isPresent()) System.out.println("largest String : " + largestString.get());
		
		//optional first match
		Optional<String> firstWord = wordList.stream().filter(s -> s.startsWith("Q")).findFirst();
		if (firstWord.isPresent()) System.out.println("first String : " + firstWord.get());
		
		//optional any match
		Optional<String> anyWord = wordList.parallelStream().filter(s -> s.startsWith("C")).findAny();
		if (anyWord.isPresent()) System.out.println("any String : " + anyWord.get());
		
		//optional any match
		boolean exists = wordList.parallelStream().anyMatch(s -> s.startsWith("Q"));
		System.out.println("String exists : " + exists);
		
		// optional return
		Optional<Boolean> optionalReturn = wordList.parallelStream().filter(s -> s.startsWith("C")).findAny().map(s -> s.length() > 4);
		if (optionalReturn.isPresent()) System.out.println("result exists : " + optionalReturn.get());
	}

	private static void armWithStream() {
		try (Stream<String> line = Files.lines(Paths.get("property/DAVINCERS_in.properties"), Charset.defaultCharset())) {
			line.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

	private static void createStream(final String contents) {
		
		Stream<String> words = Stream.of(contents.split("[\\P{L}+]"));
		words.limit(20).forEach(System.out::println);
		Stream<String> song = Stream.of("gently", "down", "the", "stream");
		song.forEach(System.out::println);
		
		// empty stream
		Stream<String> silence = Stream.empty();
		silence.forEachOrdered(System.out::println);
		
		// infinite stream
		Stream<String> echos = Stream.generate(() -> "Echos");
		echos.limit(10).forEach(System.out::println);
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(10).forEach(System.out::println);
		
		// infinite serious of numbers
		Stream<BigInteger> ap = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		ap.limit(10).forEach(System.out::println);
		
		// pattern stream
		words = Pattern.compile("[\\P{L}+]").splitAsStream(contents);
		words.limit(20).forEach(System.out::println);
		
	}

}

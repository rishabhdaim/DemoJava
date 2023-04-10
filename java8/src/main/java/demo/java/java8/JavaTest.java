package demo.java.java8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaTest {
    public static void main(String[] args) {
        List<String> l = List.of("mobile", "mouse", "moneypot", "monitor", "mousepad");

        System.out.println(threeKeywordSuggestions(5, Lists.newArrayList(l), "mouse"));
    }
        static List<List<String>> threeKeywordSuggestions(int numreviews, List<String> repository, String customerQuery) {

            final List<List<String>> result = new ArrayList<>();
            if (customerQuery != null && customerQuery.length() < 2) {
                return result;
            }
            repository.sort(String::compareTo);
            int cqLen = customerQuery.length();

            for (int i = 2; i <= cqLen; i++) {
                String cq = customerQuery.toLowerCase().substring(0, i);
                int len = cq.length();
                result.add(repository.stream().filter(s -> s.length() >= len).filter(s -> s.toLowerCase().startsWith(cq)).limit(3).collect(Collectors.toList()));
            }
            return result;
        }
}

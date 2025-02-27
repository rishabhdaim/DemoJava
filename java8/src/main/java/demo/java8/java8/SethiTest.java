package demo.java8.java8;

import java.util.*;

/**
 * Created by diam on 5/2/2018.
 */
public class SethiTest {
    public static void main (String[] args) {
        final int[] test = {3,1,2,2,4}; // [1,3,4,2,2]
        customSort(test);
    }

    private static void customSort(int[] test) {

        final List<T2> tList = new ArrayList<>();
        final Map<Integer, Integer> freqMap = new HashMap<>(test.length);
        int value = 1;
        for (int i : test) {
            value = 1;
            if (freqMap.containsKey(i)) {
                value += freqMap.get(i);
            }
            freqMap.put(i, value);
        }

        //tList.addAll(freqMap.entrySet().stream().map(entry -> new T2(entry.getValue(), entry.getKey())).collect(Collectors.toList()));

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            tList.add(new T2(entry.getValue(), entry.getKey()));
        }

        tList.sort((o1, o2) -> {
            int result = Integer.compare(o1.freq, o2.freq);
            return (result != 0) ? result : Integer.compare(o1.value, o2.value);
        });

        int i = 0;

        for(T2 t2 : tList) {
            for (int j = 0; j < t2.freq; j++) {
                test[i++] = t2.value;
            }
        }

        System.out.println(Arrays.toString(test));
    }

    private static class T2 implements Comparable<T2> {

        int freq;
        int value;

        public T2(int freq, int value) {
            this.freq = freq;
            this.value = value;
        }

        @Override
        public int compareTo(T2 o) {
            int result = Integer.compare(this.freq, o.freq);
            return (result != 0) ? result : Integer.compare(this.value, o.value);
        }
    }
}

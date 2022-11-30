package Java11;

import java.util.*;
import java.util.stream.Collectors;

public class DSTest {

    public static void main(String[] args) {

        var n = new int[]{2, 4, 5};

        int binarySearch = Arrays.binarySearch(n, 6);

        var distinct = Arrays.stream(n).distinct();
        var ints = distinct.toArray();

        set();
        bitset();
        stack();
        PriorityQueue();
        ArrayDeque();
        map();

        var input = new String[] {"adas", "adasd", "adasd"};
        List<String> collect = Arrays.stream(input).distinct().collect(Collectors.toList());
        System.out.println(collect.size() == input.length);
    }

    private static void map() {
        var map = new HashMap<Integer, Boolean>();
        var map1 = new TreeMap<Integer, Boolean>();
        var map2 = new LinkedHashMap<Integer, Boolean>();
    }

    private static void ArrayDeque() {
        var ad = new ArrayDeque<Integer>();
    }

    private static void PriorityQueue() {
        var pq = new PriorityQueue<Integer>();
    }

    private static void stack() {
        var integers = new Stack<>();
    }

    private static void bitset() {
        var b = new BitSet(100);
        System.out.println();
    }

    private static void set() {
        var someArray = new int[]{1, 2, 3, 44, 5, 6, 7};
        var mySet = Set.of(1, 2, 3, 44, 5, 6, 7);
        System.out.println(mySet);
    }
}

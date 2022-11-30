package codingInterview.ToptalSecondStage;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class B1 {

    public static void main(String[] args) throws IOException {

        String computed, expected;

        computed = new B1().solution(new String[]{"P>E", "E>R", "R>U"});
        expected = "PERU";
        out.println(computed.equals(expected));

        computed = new B1().solution(new String[]{"I>N", "A>I", "P>A", "S>P"});
        expected = "SPAIN";
        out.println(computed.equals(expected));

        computed = new B1().solution(new String[]{"I>N", "R>A", "A>I"});
        expected = "RAIN";
        out.println(computed.equals(expected));

        //out.println(Arrays.equals(computed, expected));
    }

    public String solution(String[] A) {

        Map<Character, Character> map = new HashMap<>();
        for(String edge : A) {
            map.put(edge.charAt(0), edge.charAt(2));
        }

        HashSet<Character> allowedSet = new HashSet<>();
        HashSet<Character> blockedSet = new HashSet<>();

        for(String edge : A) {

            char ch1 = edge.charAt(0);
            char ch2 = edge.charAt(2);

            allowedSet.remove(ch2);
            blockedSet.add(ch2);

            if (!blockedSet.contains(ch1)) {
                allowedSet.add(ch1);
            }
        }

        Character head = allowedSet.iterator().next();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(head);

        while (map.containsKey(head)) {
            stringBuilder.append(map.get(head));
            head = map.get(head);
        }
        return stringBuilder.toString();
    }
}
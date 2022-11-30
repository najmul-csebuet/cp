package codingInterview.ArcDev;

import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

public class B {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        B s = new B();

        possibilities("?");
        //l.add(Arrays.equals(s.possibilities("."), new int[]{}));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public static List<String> possibilities(String signals) {

        if(signals == null || signals.isEmpty()) {
            return Collections.emptyList();
        }

        Map<String, String> map = new HashMap<>();
        createMorseMap(map);

        if(map.containsKey(signals)) {
            return Collections.singletonList(map.get(signals));
        }

        List<String> list = getAllPossibleSignal(signals);
        List<String> ansList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            ansList.add(map.get(list.get(i)));
        }

        return ansList;
    }

    private static void createMorseMap(Map<String, String> map) {

        map.put(".", "E");
        map.put("-", "T");


        map.put("..", "I");
        map.put(".-", "A");
        map.put("-.", "N");
        map.put("--", "M");


        map.put("...", "S");
        map.put("..-", "U");
        map.put(".-.", "R");
        map.put(".--", "W");

        map.put("-..", "D");
        map.put("-.-", "K");
        map.put("--.", "G");
        map.put("---", "O");
    }

    private static List<String> getAllPossibleSignal(String signal) {
        if (signal.length() == 1) {

            List<String> listNew = new LinkedList<>();

            if(signal.charAt(0) != '?') {
                listNew.add(signal);
                return listNew;
            }

            listNew.add(".");
            listNew.add("-");

            return listNew;
        }

        List<String> list = getAllPossibleSignal(signal.substring(1));
        if(signal.charAt(0) != '?') {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, signal.charAt(0) + list.get(i));
            }
            return list;
        }

        List<String> listNew = new LinkedList<>();

        for (String s : list) {
            listNew.add('.' + s);
        }
        for (String s : list) {
            listNew.add('-' + s);
        }

        return listNew;
    }
}
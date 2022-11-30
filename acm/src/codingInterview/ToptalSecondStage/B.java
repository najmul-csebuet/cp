package codingInterview.ToptalSecondStage;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class B {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        B s = new B();
        ArrayList<Boolean> l = new ArrayList<>();

        l.add(s.solution(new String[]{"P>E","E>R","R>U"}).equals("PERU"));
        l.add(s.solution(new String[]{"I>N","A>I","P>A","S>P"}).equals("SPAIN"));

        checkTestCases(l);
    }

    private String getTop(ArrayList<String> array) {

        String top = "";
        for (int i = 0; i < array.size(); i++) {
            boolean flag = true;
            String first = array.get(i);
            for (int j = i + 1; j < array.size(); j++) {
                String second = array.get(j);
                if (first.charAt(0) == second.charAt(2)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                top = first;
                break;
            }
        }
        return top;
    }

    public String solution(String[] array) {

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));

        StringBuilder ans = new StringBuilder();

        while (arrayList.size() != 0) {
            String tempTop = getTop(arrayList);
            arrayList.remove(tempTop);
            if (ans.length() == 0) {
                ans.append(tempTop);
            } else {
                ans.append(tempTop.charAt(2));
            }
        }

        return ans.toString().replaceAll(">", "");
    }
}
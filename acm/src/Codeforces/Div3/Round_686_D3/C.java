package Codeforces.Div3.Round_686_D3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class C {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !C.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {

            int N = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; ++i) list.add(sc.nextInt());

            new C().solution(list);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(C.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer first = list.get(i);
            newList.add(first);
            int j = i + 1;
            for (; j < list.size(); j++) {
                if (first != list.get(j)) {
                    break;
                }
            }
            i = j - 1;
        }

        var freqMap = getFreqMap(newList);

        freqMap.put(newList.get(0), freqMap.get(newList.get(0)) - 1);
        freqMap.put(newList.get(newList.size() - 1), freqMap.get(newList.get(newList.size() - 1)) - 1);

        int minValue = Integer.MAX_VALUE;
        for (int key : freqMap.keySet()) {
            if(freqMap.getOrDefault(minValue, Integer.MAX_VALUE) > freqMap.get(key)) {
                minValue = key;
            }
        }

        out.println(freqMap.get(minValue) + 1);
    }

    public static Map<Integer, Integer> getFreqMap(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : list) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return map;
    }
}

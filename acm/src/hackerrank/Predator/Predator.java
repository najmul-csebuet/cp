package hackerrank.Predator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Predator {

    public static Scanner sc;
    public static PrintWriter out;

    private HashMap<Integer, List<Integer>> levelMap;
    private HashMap<Integer, List<Integer>> childMap;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Predator.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Predator.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int repeat = 1;
        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i) N[i] = sc.nextInt();

            long start = System.currentTimeMillis();
            for (int i = 0; i < repeat; i++) {
                new Predator().solution(N);
            }
            long end = System.currentTimeMillis();
            System.out.println("Solve Difference: " + (end - start));
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < repeat; i++) {
            int i1 = checkBetter1();
            System.out.println(i1);
        }
        long end = System.currentTimeMillis();
        System.out.println("Check better difference: " + (end - start));

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(Predator.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int[] n) {

        levelMap = new HashMap<>();
        childMap = new HashMap<>();

        for (int i = 0; i < n.length; i++) {
            updateMap(childMap, n[i], i);
        }

        List<Integer> rootList = childMap.get(-1);
        for (int i = 0; i < rootList.size(); i++) {
            searchTree(rootList.get(i), 0);
        }

        print();
    }

    private void searchTree(int parent, int depthOfParent) {
        updateMap(levelMap, depthOfParent, parent);
        List<Integer> childList = childMap.getOrDefault(parent, new ArrayList<>());
        for (Integer integer : childList) {
            searchTree(integer, depthOfParent + 1);
        }
    }

    private void print() {
        for (int i = 0; i < levelMap.keySet().size(); i++) {
            List<Integer> integers = levelMap.get(i);
            for (int j = 0; j < integers.size() - 1; j++) {
                out.print(integers.get(j) + " ");
            }
            out.println(integers.get(integers.size() - 1));
        }
    }

    private void updateMap(HashMap<Integer, List<Integer>> map, int key, int value) {
        List<Integer> orDefault = map.getOrDefault(key, new ArrayList<>());
        orDefault.add(value);
        map.put(key, orDefault);
    }

    private static int checkBetter() {
        int[] ints =  {-1, 8, 6, 0, 7, 3, 8, 9, -1, 6, 1};
        int max = 1;
        int arrLen = ints.length;
        for (var i = 0; i < ints.length; i++)
        {
            var a = i;
            var counter = 1;
            while (ints[a] > -1 && ints[a] < arrLen && counter < arrLen)
            {
                a = ints[a];
                counter++;
            }
            if (counter > max)
                max = counter;
        }
        return max;
    }

    private static int checkBetter1() {
        int[] ints =  {-1, 8, 6, 0, 7, 3, 8, 9, -1, 6, 1};
        int max = 0;
        for (var i = 0; i < ints.length; i++) {
            var a = i;
            var counter = 1;
            while (ints[a] > -1) {
                a = ints[a];
                counter++;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}

package Codeforces.Div3.Round_686_D3;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class B {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !B.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i)N[i] = sc.nextInt();

            new B().solution(N);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(B.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int[] n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            map.put(n[i], map.getOrDefault(n[i], 0) + 1);
        }

        int minValue = -1;
        for(int value : map.keySet()) {
            if (map.get(value) > 1)continue;
            if (minValue == -1)minValue = value;
            else if(minValue > value) {
                minValue = value;
            }
        }
        int index = -1;
        for (int i = 0; i < n.length; i++) {
            if (n[i] == minValue) {
                index = i + 1;
                break;
            }
        }
        out.println(index);
    }
}

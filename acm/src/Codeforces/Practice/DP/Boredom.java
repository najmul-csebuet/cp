package Codeforces.Practice.DP;

import java.io.*;
import java.util.*;

public class Boredom {

    long improvedAns(Map<Integer, Integer> freqMap) {

        long[] array = new long[100001];
        for (Integer a : freqMap.keySet()) {
            array[a] = a;
        }

        array[0] = 0;
        array[1] = freqMap.getOrDefault(1, 0);

        for (int i = 2; i < array.length; i++) {
            array[i] = Math.max(array[i - 1], array[i - 2] + (long)(freqMap.getOrDefault(i, 0))*i);
        }

        return array[array.length - 1];
    }

    private int ans(Map<Integer, Integer> freqMap) {

        if (freqMap.size() == 0)return 0;

        int max = 0;

        for (Integer key : freqMap.keySet()) {

            int b = freqMap.getOrDefault(key, 0);
            if (b == 0)continue;

            int a = freqMap.getOrDefault(key - 1, 0);
            int c = freqMap.getOrDefault(key + 1, 0);

            if (a > 0)freqMap.put(key - 1, 0);
            if (b > 0)freqMap.put(key, 0);
            if (c > 0)freqMap.put(key + 1, 0);

            int total =  b * key + ans(freqMap);
            if (max < total) {
                max = total;
            }

            if (a > 0)freqMap.put(key - 1, a);
            if (b > 0)freqMap.put(key, b);
            if (c > 0)freqMap.put(key + 1, c);
        }

        return max;
    }

    public void solve(int[] array) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            freqMap.put(array[i], freqMap.getOrDefault(array[i], 0) + 1);
        }

        //out.println(ans(freqMap));
        out.println(improvedAns(freqMap));
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = Boredom.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Boredom.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            new Boredom().solve(array);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(Boredom.class.getResource("ans.txt").getFile()));
            BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            boolean areEqual = true;
            int lineNum = 1;

            while (line1 != null || line2 != null) {

                if (line1 == null || line2 == null) {

                    areEqual = false;
                    break;
                } else if (!line1.equals(line2)) {

                    areEqual = false;
                    break;
                }

                line1 = reader1.readLine();
                line2 = reader2.readLine();

                lineNum++;
            }

            if (areEqual) {

                System.out.println("All Test Cases Passed !");
            } else {

                System.out.println("Output differ at line " + lineNum);
                System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
            }

            reader1.close();
            reader2.close();
        }
    }
}

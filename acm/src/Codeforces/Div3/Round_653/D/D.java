package Codeforces.Div3.Round_653.D;

import java.io.*;
import java.util.*;

public class D {

    public void solve(Integer[] n, Integer k) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer a:n) {
            if (a == 0)continue;
            hashMap.put(a, hashMap.getOrDefault(a, 0) + 1);
        }

        if (hashMap.size() == 0) {
            out.println(0);
            return;
        }

        Integer maxKey = -1, maxValue = -1;
        for (Integer key: hashMap.keySet()) {
            if (hashMap.get(key) > maxValue) {
                maxKey = key;
                maxValue = hashMap.get(key);
            }
            else if (hashMap.get(key).equals(maxValue) && key < maxKey) {
                maxKey = key;
                maxValue = hashMap.get(key);
            }
        }

         Long ans = (maxValue - 1l) * k + (k - maxKey) + 1;
        out.println(ans);
    }

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = D.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int NLength = sc.nextInt();
            int K = sc.nextInt();

            Integer[] N = new Integer[NLength];

            for (int NIndex = 0; NIndex < N.length; NIndex++) {
                N[NIndex] = sc.nextInt() % K;
            }


            new D().solve(N, K);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(D.class.getResource("ans.txt").getFile()));
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

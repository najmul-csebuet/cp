package Codeforces.Div3.R479.B;

import java.io.*;
import java.util.*;

public class B {

    public void solve(int n, String s) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int step = 0; step < s.length() - 1; step++) {

            if (hashMap.containsKey(s.substring(step, step+2)))continue;

            int count = 1;
            for (int next = step + 1; next < s.length() - 1; next++) {
                if (s.charAt(step) == s.charAt(next) && s.charAt(step+1) == s.charAt(next+1)) {
                    ++count;
                }
            }

            hashMap.put(s.substring(step, step+2), count);
        }

        String maxSt = "";
        int count = -1;
        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) > count) {
                maxSt = key;
                count = hashMap.get(key);
            }
        }

        out.println(maxSt);
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = B.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? B.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            String S = sc.next();
            new B().solve(N, S);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(B.class.getResource("ans.txt").getFile()));
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

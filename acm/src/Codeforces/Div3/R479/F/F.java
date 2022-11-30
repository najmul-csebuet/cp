package Codeforces.Div3.R479.F;

import java.io.*;
import java.util.*;

public class F {

    public void solve(int[] a) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.getOrDefault(a[i] - 1, 0) == 0) {
                map.put(a[i], 1);
                continue;
            }
            map.put(a[i], map.get(a[i] - 1) + 1);
        }

        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if (map.getOrDefault(a[i], 0) > map.getOrDefault(max, 0)) {
                max = a[i];
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == max) {
                arrayList.add(i+1);
                --max;
            }
        }

        out.println(arrayList.size());
        for (int i = arrayList.size() - 1; i > 0; i--) {
            out.print(arrayList.get(i) + " ");
        }
        out.print(arrayList.get(0) + "\n");
        out.flush();
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = F.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? F.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int aLength = sc.nextInt();
            int[] a = new int[aLength];

            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            new F().solve(a);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(F.class.getResource("ans.txt").getFile()));
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

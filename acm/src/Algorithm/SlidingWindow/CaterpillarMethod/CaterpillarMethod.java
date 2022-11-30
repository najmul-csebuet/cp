package Algorithm.SlidingWindow.CaterpillarMethod;

import java.io.*;
import java.util.*;

public class CaterpillarMethod {

    public Boolean solution(int[] A, int sum) {

        int n = A.length;
        int front = 0, total = 0;

        for (int back = 0; back < n; back++) {

            while (front < n && total + A[front] <= sum) {
                total += A[front];
                ++front;
            }

            if (total == sum) {
                out.println("true");
                return true;
            }

            total -= A[back];
        }

        out.println("false");
        return false;
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = CaterpillarMethod.class.getPackage() != null;
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CaterpillarMethod.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = CaterpillarMethod.class.getPackage() != null;
        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int aLength = sc.nextInt();
            int[] a = new int[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            int S = sc.nextInt();
            new CaterpillarMethod().solution(a, S);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(CaterpillarMethod.class.getResource("ans.txt").getFile()));
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

package Codility.Lessons.L4.Old1.PermCheck;

import java.io.*;
import java.util.*;

public class Solution {

    public int solution(int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= A.length; i++) {
            hashSet.add(i);
        }

        for (int a : A) {
            hashSet.remove(a);
        }

        if (hashSet.isEmpty()) {
            out.println(1);
            return 1;
        }

        out.println(0);
        return 0;
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int aLength = sc.nextInt();
            int[] a = new int[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            new Solution().solution(a);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(Solution.class.getResource("ans.txt").getFile()));
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
    private void printArray(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            out.print(array[i] + " ");
        }

        if (array.length > 0)
            out.println(array[array.length - 1]);
        else
            out.println();
    }
}

package Codility.Lessons.L14.NailingPlanks;

import java.io.*;
import java.util.*;

public class Solution {

    static class Plank {

        int a,b;

        Plank(int a, int b) {
            this.a = a;
            this.b = b;
        }

        boolean contains(int c) {
            return a <= c && c <= b;
        }
    }

    public int solution(int[] A, int[] B, int[] C) {

        LinkedList<Plank> list = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(new Plank(A[i], B[i]));
        }

        int usedIndex = 0;
        for (; usedIndex < C.length; usedIndex++) {

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).contains(C[usedIndex])) {
                    list.remove(j);
                    --j;
                }
            }

            if (list.size() == 0)break;
        }

        if (list.isEmpty()) {
            ++usedIndex;
            out.println(usedIndex);
            return usedIndex;
        }

        out.println(-1);
        return -1;
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = Solution.class.getPackage() != null;
        sc = getScanner(fileInOut);
        try {
            out = getPrintWriter(fileInOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Scanner getScanner(boolean fileInOut) {
        return new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
    }

    private static PrintWriter getPrintWriter(boolean fileInOut) throws FileNotFoundException {
        return new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;
        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int aLength = sc.nextInt();
            int[] a = new int[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            int BLength = sc.nextInt();
            int[] B = new int[BLength];

            for (int BIndex = 0; BIndex < B.length; BIndex++) {
                B[BIndex] = sc.nextInt();
            }

            int CLength = sc.nextInt();
            int[] C = new int[CLength];

            for (int CIndex = 0; CIndex < C.length; CIndex++) {
                C[CIndex] = sc.nextInt();
            }

            new Solution().solution(a, B, C);
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
}

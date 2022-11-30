package Codeforces.Div3.Round_481.C_Letters;

import java.io.*;
import java.util.*;

public class C_Letters {
    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = C_Letters.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C_Letters.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int dormitoryCount = sc.nextInt();
            int letterCount = sc.nextInt();

            int ALength = dormitoryCount;
            long[] A = new long[ALength];
            for (int AIndex = 0; AIndex < A.length; AIndex++) {
                A[AIndex] = sc.nextLong();
            }

            int BLength = letterCount;
            long[] B = new long[BLength];
            for (int BIndex = 0; BIndex < B.length; BIndex++) {
                B[BIndex] = sc.nextLong();
            }

            new C_Letters().solution(dormitoryCount, letterCount, A, B);
        }

        if (fileInOut) {
            verify(C_Letters.class.getResource("ans.txt").getFile());
        }
    }
    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
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

    public void solution(int dormitoryCount, int letterCount, long[] A, long[] B) {

        long[] prefixSum = new long[A.length];
        long total = 0;

        for (int i = 0; i < A.length; i++) {

            total += A[i];
            prefixSum[i] = total;
        }

        for (int i = 0; i < B.length; i++) {

            int index = Arrays.binarySearch(prefixSum, B[i]);
            if (index < 0) {
                index = Math.abs(index) - 1;
            }

            if (index > 0) {
                out.println((index + 1) + " " + (B[i] - prefixSum[index - 1]));
            }
            else {
                out.println((index + 1) + " " + (B[i]));
            }
        }
    }
}

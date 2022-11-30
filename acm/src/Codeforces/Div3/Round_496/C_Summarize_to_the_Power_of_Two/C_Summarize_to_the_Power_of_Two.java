package Codeforces.Div3.Round_496.C_Summarize_to_the_Power_of_Two;

import java.io.*;
import java.util.*;

public class C_Summarize_to_the_Power_of_Two {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = C_Summarize_to_the_Power_of_Two.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C_Summarize_to_the_Power_of_Two.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int ALength = sc.nextInt();
            int[] A = new int[ALength];

            for (int AIndex = 0; AIndex < A.length; AIndex++) {
                A[AIndex] = sc.nextInt();
            }

            new C_Summarize_to_the_Power_of_Two().solution(A);
        }

        if (fileInOut) {
            verify(C_Summarize_to_the_Power_of_Two.class.getResource("ans.txt").getFile());
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

    public void solution(int[] A) {

        if (A.length == 0) {
            out.println(0);
            return;
        }

        if (A.length == 1) {
            out.println(1);
            return;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
        }

        int toDelete = 0;

        for (int i = 0; i < A.length; i++) {

            boolean hasPair = false;

            for (int j = 0; j < 32; j++) {
                int twoD = 1 << j;
                int sub = twoD - A[i];
                if (sub < 0)continue;

                if (hashMap.getOrDefault(sub, 0) > 1) {
                    hasPair = true;
                    break;
                }

                if (hashMap.getOrDefault(sub, 0) == 1 && A[i] != sub) {
                    hasPair = true;
                    break;
                }
            }

            if (!hasPair) {
                ++toDelete;
            }
        }

        out.println(toDelete);
    }
}

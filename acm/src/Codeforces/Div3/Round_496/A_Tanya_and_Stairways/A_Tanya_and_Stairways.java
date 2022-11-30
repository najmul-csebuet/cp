package Codeforces.Div3.Round_496.A_Tanya_and_Stairways;

import java.io.*;
import java.util.*;

public class A_Tanya_and_Stairways {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = A_Tanya_and_Stairways.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? A_Tanya_and_Stairways.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int ALength = sc.nextInt();
            int[] A = new int[ALength + 1];
            
            for (int AIndex = 0; AIndex < A.length - 1; AIndex++) {
                A[AIndex] = sc.nextInt();
            }
            A[A.length - 1] = -1;
            new A_Tanya_and_Stairways().solution(A);
        }

        if (fileInOut) {
            verify(A_Tanya_and_Stairways.class.getResource("ans.txt").getFile());
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

        int stairCaseCount = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i+1]) {
                continue;
            }
            list.add(A[i]);
            ++stairCaseCount;
        }

        out.println(stairCaseCount);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                out.print(list.get(i) + " ");
            } else {
                out.println(list.get(i));
            }
        }
    }
}

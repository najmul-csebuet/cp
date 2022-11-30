package Codeforces.Div3.Round_481.A_Remove_Duplicates;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class A_Remove_Duplicates {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = A_Remove_Duplicates.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? A_Remove_Duplicates.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int ALength = sc.nextInt();
            int[] A = new int[ALength];

            for (int AIndex = 0; AIndex < A.length; AIndex++) {
                A[AIndex] = sc.nextInt();
            }

            new Solution().solution(A);
        }

        if (fileInOut) {
            verify(A_Remove_Duplicates.class.getResource("ans.txt").getFile());
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
}

class Solution {

    public static PrintWriter out;

    public void solution(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int n : A) {
            if (map.get(n) > 1) {
                map.put(n, map.get(n)-1);
                continue;
            }
            arrayList.add(n);
        }

        out.println(arrayList.size());
        for (int i = 0; i < arrayList.size() - 1; i++) {
            out.print(arrayList.get(i) + " ");
        }

        if (arrayList.size() >= 1)out.println(arrayList.get(arrayList.size() - 1));
    }
}

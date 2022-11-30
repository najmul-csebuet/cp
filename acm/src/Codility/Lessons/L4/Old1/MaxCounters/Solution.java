package Codility.Lessons.L4.Old1.MaxCounters;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public int[] solution(int N, int[] A) {
        int base = 0;
        int count = 0;
        var hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                base += count;
                count = 0;
                hashMap = new HashMap<>();
            }
            else {
                hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
                if (hashMap.get(A[i]) > count) {
                    count = hashMap.get(A[i]);
                }
            }
        }

        int[] ans = new int[N];
        for (int i = 1; i < N; i++) {
            ans[i - 1] = hashMap.getOrDefault(i, 0) + base;
            out.print(ans[i - 1] + " ");
        }

        ans[N - 1] = hashMap.getOrDefault(N, 0) + base;
        out.println(ans[N - 1]);
        return ans;
    }

    public static PrintWriter out;
    private void printArray(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            out.print(array[i] + " ");
        }

        if (array.length > 0)
            out.println(array[array.length - 1]);
        else
            out.println();
    }
    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            int aLength = sc.nextInt();
            int[] a = new int[aLength];
            for (int aIndex = 0; aIndex < a.length; aIndex++) {
                a[aIndex] = sc.nextInt();
            }

            new Solution().solution(N, a);
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

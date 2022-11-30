package Codility.Lessons.L5.GenomicRangeQuery;

import java.io.*;
import java.util.*;

class Node {

    int a = 0, c = 0, g = 0, t = 0;

    void updateStat(char ch) {
        if (ch == 'A')++a;
        else if (ch == 'C')++c;
        else if (ch == 'G')++g;
        else if (ch == 'T')++t;
    }

    void copyStat(Node other) {
        a = other.a;
        c = other.c;
        g = other.g;
        t = other.t;
    }
}

public class Solution {

    public int[] solution(String S, int[] P, int[] Q) {

        Node[] prefixSum = new Node[S.length()];
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSum[i] = new Node();
        }
        prefixSum[0].updateStat(S.charAt(0));

        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            prefixSum[i].copyStat(prefixSum[i-1]);
            prefixSum[i].updateStat(ch);
        }

        int ansIndex = -1;
        int[] ans = new int[P.length];

        for (int i = 0; i < P.length; i++) {

            int left = P[i];
            int right = Q[i];

            Node leftNode = prefixSum[left];
            Node rightNode = prefixSum[right];

            Node newNode = new Node();
            newNode.a = rightNode.a - leftNode.a;
            newNode.c = rightNode.c - leftNode.c;
            newNode.g = rightNode.g - leftNode.g;
            newNode.t = rightNode.t - leftNode.t;
            newNode.updateStat(S.charAt(left));

            if (newNode.a > 0)ans[++ansIndex] = 1;
            else if (newNode.c > 0)ans[++ansIndex] = 2;
            else if (newNode.g > 0)ans[++ansIndex] = 3;
            else if (newNode.t > 0)ans[++ansIndex] = 4;
            /*int min = 5;
            for (int j = left; j <= right; j++) {
                if (S.charAt(j) == 'A') {
                    min = Math.min(min, 1);
                }
                else if (S.charAt(j) == 'C') {
                    min = Math.min(min, 2);
                }
                else if (S.charAt(j) == 'G') {
                    min = Math.min(min, 3);
                }
                else if (S.charAt(j) == 'T') {
                    min = Math.min(min, 4);
                }
            }
            ans[++ansIndex] = min;*/
        }

        printArray(ans);

        return ans;
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = Solution.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Solution.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            String S = sc.next();

            int PLength = sc.nextInt();
            int[] P = new int[PLength];

            for (int PIndex = 0; PIndex < P.length; PIndex++) {
                P[PIndex] = sc.nextInt();
            }

            int QLength = sc.nextInt();
            int[] Q = new int[QLength];

            for (int QIndex = 0; QIndex < Q.length; QIndex++) {
                Q[QIndex] = sc.nextInt();
            }


            new Solution().solution(S, P, Q);
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

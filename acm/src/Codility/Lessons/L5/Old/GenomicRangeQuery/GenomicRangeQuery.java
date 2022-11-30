package Codility.Lessons.L5.Old.GenomicRangeQuery;

import java.io.*;
import java.util.*;

public class GenomicRangeQuery {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = GenomicRangeQuery.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? GenomicRangeQuery.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            String st = sc.next();

            int pLength = sc.nextInt();
            int[] p = new int[pLength];

            for (int pIndex = 0; pIndex < p.length; pIndex++) {
                p[pIndex] = sc.nextInt();
            }

            int qLength = sc.nextInt();
            int[] q = new int[qLength];

            for (int qIndex = 0; qIndex < q.length; qIndex++) {
                q[qIndex] = sc.nextInt();
            }

            new Solution().solution(st, p, q);
        }

        if (fileInOut) {

            verify(GenomicRangeQuery.class.getResource("ans.txt").getFile());
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

class FreqCount {
    int A,C,G,T;

    public FreqCount getClone() {
        FreqCount freqCount = new FreqCount();
        freqCount.A = this.A;
        freqCount.C = this.C;
        freqCount.G = this.G;
        freqCount.T = this.T;
        return freqCount;
    }
}

class Solution {

    public static PrintWriter out;

    public int[] solution(String S, int[] P, int[] Q) {

        FreqCount[] freqCounts = new FreqCount[S.length()];

        for (int i = 0; i < S.length(); i++) {

            FreqCount freqCount = i > 0? freqCounts[i - 1].getClone(): new FreqCount();

            if (S.charAt(i) == 'A') {
                freqCount.A +=1;
            }
            else if (S.charAt(i) == 'C') {
                freqCount.C +=1;
            }
            else if (S.charAt(i) == 'G') {
                freqCount.G +=1;
            }
            else if (S.charAt(i) == 'T') {
                freqCount.T +=1;
            }

            freqCounts[i] = freqCount;
        }

        for (int i = 0; i < P.length; i++) {

            int start = P[i];
            int end = Q[i];

            FreqCount endFreq = freqCounts[end];

            FreqCount freqCount = new FreqCount();

            if (start == 0) {
                freqCount = endFreq;
            }
            else if (start > 0) {

                FreqCount startFreq = freqCounts[start - 1];

                freqCount.A = endFreq.A - startFreq.A;
                freqCount.C = endFreq.C - startFreq.C;
                freqCount.G = endFreq.G - startFreq.G;
                freqCount.T = endFreq.T - startFreq.T;
            }

            if (freqCount.A > 0) {
                P[i] = 1;
                out.print(1);
            }
            else if (freqCount.C > 0) {
                P[i] = 2;
                out.print(2);
            }
            else if (freqCount.G > 0) {
                P[i] = 3;
                out.print(3);
            }
            else if (freqCount.T > 0) {
                P[i] = 4;
                out.print(4);
            }

            if (i < P.length - 1) {
                out.print(" ");
            }
            else {
                out.println();
            }

            //out.flush();
        }
        return P;
    }

    private void printArray(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            out.print(A[i] + ' ');
        }
        if (A.length > 0) {
            out.println(A[A.length - 1]);
        }
    }
}

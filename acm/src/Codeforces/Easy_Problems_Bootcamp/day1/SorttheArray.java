package Codeforces.Easy_Problems_Bootcamp.day1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class SorttheArray {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !SorttheArray.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int[] A = new int[io.nextInt()];
            for (int i = 0; i < A.length; ++i) A[i] = io.nextInt();

            new SorttheArray().solution(A);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get("ans.txt")).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else {
                for (int i = 0; i < ansFileText.length; i++) {
                    if (i >= outFileText.length) {
                        System.out.println("<NO OUTPUT> ------> " + ansFileText[i]);
                    } else if (!ansFileText[i].equals(outFileText[i])) {
                        System.out.println(outFileText[i] + " ------> " + ansFileText[i]);
                    } else {
                        System.out.println(outFileText[i]);
                    }
                }
            }
        }
    }

    private boolean isSorted(int[] a, int s, int e) {
        for (int i = s; i < e; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    private void reverse(int[] a, int s, int e) {
        for (int i = s, j = e; i < j; i++, j--) {
            //a[i] ^= a[j] ^= a[i];
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }

    public void solution(int[] a) {
        // 1 2 3 4 5 6 --> yes 1 1
        // 1 2 3 4   6 5

        // 2 1 4 3 5 6 --> multiple dec seg --> no
        // 2 1 3 4 5 6

        // 2 1

        // 1 2 3 6 5 4 7 8

        int i;
        for (i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) break;
        }

        if (i + 1 == a.length) {
            // no dec so sorted
            io.println("yes\n1 1");
            return;
        }

        int firstDecIndex = i;
        // now search for another dec segment, if so, not possible
        for (; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) break;
        }

        if (i + 1 == a.length) {
            // only 1 dec ended at last index
            handleLeftFlipValidity(a, firstDecIndex, i);
//            io.printf("yes\n%d %d\n", firstDecIndex + 1, i + 1);
            return;
        }

        // chk if at least this reversal is invalid
        if (a[firstDecIndex] > a[i + 1]) {
            io.println("no");
            return;
        }

        int endOfLastSegment = i;
        for (; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                // so multiple dec seg, not possible in 1 reversal
                io.println("no");
                return;
            }
        }

        handleLeftFlipValidity(a, firstDecIndex, endOfLastSegment);
    }

    private void handleLeftFlipValidity(int[] a, int firstDecIndex, int endOfLastSegment) {
        if(firstDecIndex == 0) {
            io.printf("yes\n%d %d\n", firstDecIndex + 1, endOfLastSegment + 1);
        }
        else {
            if(a[firstDecIndex - 1] > a[endOfLastSegment]) {
                io.println("no");
            }
            else {
                io.printf("yes\n%d %d\n", firstDecIndex + 1, endOfLastSegment + 1);
            }
        }
    }

/*    public void solution1(int[] a) {
        if (isSorted(a, 0, a.length - 1)) {
            io.println("yes");
            io.printf("%d %d\n", 1, 1);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (isSorted(a, i, j)) continue;

                reverse(a, i, j);
                if (isSorted(a, 0, a.length - 1)) {
                    io.println("yes");
                    io.printf("%d %d\n", (i + 1), (j + 1));
                    return;
                }
                reverse(a, i, j);
            }
        }
        io.println("no");
    }*/

    static class FastIO extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        public FastIO(boolean fileInOut) throws FileNotFoundException {
            super(fileInOut ? new FileOutputStream("out.txt") : System.out, true);
            br = new BufferedReader(new InputStreamReader(fileInOut ? new FileInputStream("in.txt") : System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

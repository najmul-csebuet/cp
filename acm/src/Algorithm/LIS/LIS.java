package Algorithm.LIS;

import Common.Verifier;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class LIS {

    private int solve(int[] array) {

        int[] L = new int[array.length];
        Arrays.fill(L, 1);

        int max = 1;
        for (int i = 1; i < array.length; i++) {

            for (int j = 0; j < i; j++) {

                if(array[i] < array[j]) {
                    continue;
                }

                if (L[i] <= L[j]) {

                    L[i] = L[j] + 1;

                    if (L[i] > max) {
                        max = L[i];
                    }
                }
            }
        }

        return max;
    }

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = true;

        //sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //out = new PrintWriter(new BufferedOutputStream(System.out), true);

        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? LIS.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        LIS lis = new LIS();

        out.println("Case 1# " + lis.solve(new int[] {3, 2}));
        out.println("Case 2# " + lis.solve(new int[] {3, 10, 2, 1, 20}));
        out.println("Case 3# " + lis.solve(new int[] {50, 3, 10, 7, 40, 80}));
        out.println("Case 4# " + lis.solve(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80}));

        Verifier.verify(LIS.class.getResource("ans.txt").getFile());
    }
}
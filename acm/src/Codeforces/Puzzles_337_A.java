package Codeforces;

import java.io.*;
import java.util.*;

public class Puzzles_337_A {

    public static void main(String[] args) {

        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[m];

        for(int i = 0; i < m; ++i) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        int min = 1001;
        for (int i = 0; i<=(m-n);++i) {
            int j = n+ i- 1;
            int AB = array[j] - array[i];
            if(min > AB) {
                min = AB;
            }
        }

        out.print(min);
        out.close();
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    //--------------------------------------------------------
}
package Codeforces.Easy_Problems_Bootcamp.day1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ReverseAnArray {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !ReverseAnArray.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = 1;
        for (int t = 1; t <= totalTC; t++) {
            var N = new ArrayList<Integer>();
            int N_size = io.nextInt();
            for (int i = 0; i < N_size; ++i) N.add(io.nextInt());

            new ReverseAnArray().solution(N);
        }
        io.flush();
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

    public void solution(List<Integer> n) {
        Collections.reverse(n);
        for (int i = 0; i < n.size(); i++) {
            io.print(n.get(i) + " ");
        }
    }

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

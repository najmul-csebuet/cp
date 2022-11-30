package Codementor;

import java.io.*;
import java.util.*;

public class SolutionNew {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

    public static FastReader sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean testLocally = !SolutionNew.class.getPackage().getName().isEmpty();
        out = new PrintWriter(new BufferedOutputStream(testLocally ? new FileOutputStream("out.txt") : System.out), true);

        if (testLocally) {
            List<Boolean> l = new ArrayList<>();
            SolutionNew s = new SolutionNew();

            l.add(s.solution() == 0);
            //l.add(Arrays.equals(s.solution(), new int[]{));

            if (!l.contains(false)) System.out.println("All Test Cases Passed.");
            else for (int i = 0; i < l.size(); i++) if (!l.get(i)) System.out.println("Case " + (i + 1) + ": Failed");
        } else {
            sc = new FastReader();
            int totalTC = sc.nextInt();
            for (int t = 1; t <= totalTC; t++) {
                new SolutionNew().solution();
            }
        }
    }

    public int solution() {
        out.println(0);
        return 0;
    }
}

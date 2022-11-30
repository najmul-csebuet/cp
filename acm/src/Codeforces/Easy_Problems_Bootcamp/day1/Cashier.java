package Codeforces.Easy_Problems_Bootcamp.day1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Cashier {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Cashier.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int n = io.nextInt();
            int L = io.nextInt();
            int a = io.nextInt();

            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int ti = io.nextInt();
                int li = io.nextInt();
                list.add(new Pair(ti, li));
            }
            new Cashier().solution(list, L, a);
        }

        if (fileInOut) {
            var ansFileText = Files.readAllLines(Paths.get("ans.txt")).toArray(new String[0]);
            var outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
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

    public void solution(List<Pair> list, int L, int a) {

        list.add(0, new Pair(0, 0));
        list.add(new Pair(L, 0));

        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            Pair second = list.get(i);
            Pair first = list.get(i - 1);
            ans += (second.start - first.end) / a;
        }
        io.println(ans);
    }

    static class Pair {
        int start, end;

        public Pair(int ti, int li) {
            start = ti;
            end = ti + li;
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

package Codeforces.Div3.Round_744;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A {

    public static FastReader sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !A.class.getPackage().getName().isEmpty();
        sc = new FastReader(fileInOut);
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            String next = sc.next();
            new A().solution(next);
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

    public void solution(String next) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < next.length(); i++) {
            if (next.charAt(i) == 'A') ++a;
            else if (next.charAt(i) == 'B') ++b;
            else if (next.charAt(i) == 'C') ++c;
        }

        b -= a;
        b -= c;

        if(b == 0) {
            out.println("YES");
        }
        else {
            out.println("NO");
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader(boolean fileInOut) throws FileNotFoundException {
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

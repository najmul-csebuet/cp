package Codeforces.Div3.Round_744;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class B {

    public static FastReader sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !B.class.getPackage().getName().isEmpty();
        sc = new FastReader(fileInOut);
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : sc.nextInt();
        for (int t = 1; t <= totalTC; t++) {
            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i) N[i] = sc.nextInt();

            new B().solution(N);
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

    public void solution(int[] n) {
        List<Integer> listL = new ArrayList<>();
        List<Integer> listR = new ArrayList<>();
        for (int i = 0; i < n.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n.length; j++) {
                if (n[j] < n[minIndex]) {
                    minIndex = j;
                }
            }
            if (i < minIndex) {
                listL.add(i + 1);
                listR.add(minIndex + 1);
            } else {
                continue;
            }

            List<Integer> list = new ArrayList<>();
            int d = minIndex - i;
            for (int j = d; i + j <= minIndex; j++) {
                list.add(n[i + j]);
            }

            for (int j = 0; j < d; j++) {
                list.add(n[i + j]);
            }

            for (int j = 0; j < list.size(); j++) {
                n[i + j] = list.get(j);
            }
        }

        out.println(listL.size());
        for (int i = 0; i < listL.size(); i++) {
            out.printf("%d %d %d\n", listL.get(i), listR.get(i), listR.get(i) - listL.get(i));
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

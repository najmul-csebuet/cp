package Codeforces.Easy_Problems_Bootcamp.day6;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class P52 {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !P52.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            var A = io.nextInts();
            new P52().solution(A);
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

    public void solution(int[] A) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> lMap = new HashMap<>();
        Map<Integer, Integer> rMap = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) + 1);

            if (!lMap.containsKey(a)) {
                lMap.put(a, i);
            }

            rMap.put(a, i);
        }

        int maxFreq = -1;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > maxFreq) {
                maxFreq = frequencyMap.get(key);
            }
        }

        int l, r, L = -1, R = -1;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == maxFreq) {
                l = lMap.get(key) + 1;
                r = rMap.get(key) + 1;
                if (L == -1 || (r - l) < (R - L)) {
                    L = l;
                    R = r;
                }
            }
        }

        io.println(L + " " + R);
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

        int[] nextInts() {
            int N = nextInt();
            return nextInts(N);
        }

        int[] nextInts(int N) {
            var res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        void print(int[] n) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                io.print(n[i] + " ");
            }
            io.println(n[n.length - 1]);
        }

        void reversePrint(int[] n) {
            if (n.length == 0) return;
            for (int i = n.length - 1; i > 0; i--) {
                io.print(n[i] + " ");
            }
            io.println(n[0]);
        }

        void print(List<Integer> n) {
            if (n.size() == 0) return;
            for (int i = 0; i < n.size() - 1; i++) {
                io.print(n.get(i) + " ");
            }
            io.println(n.get(n.size() - 1));
        }

        void reversePrint(List<Integer> n) {
            if (n.size() == 0) return;
            for (int i = n.size() - 1; i > 0; i--) {
                io.print(n.get(i) + " ");
            }
            io.println(n.get(0));
        }
    }

}

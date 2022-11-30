package Codeforces.Easy_Problems_Bootcamp.exam1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class E {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !E.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            Integer N = io.nextInt();
            new E().solution(N);
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

    public void solution(Integer n) {
        List<Integer> list = Util.getPrimeNumbers(n);
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>(list);
        for (int i = 0; i < list.size(); i++) {
            int e = list.get(i) + list.get(0);
            if (e > n) break;
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                e = list.get(i) + list.get(j);
                if (e <= n && set1.contains(e))
                    set.add(e);
                else break;
            }
        }
        io.println(set.size());
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

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
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

        Integer[] nextInts() {
            Integer N = nextInt();
            return nextInts(N);
        }

        Integer[] nextInts(Integer N) {
            var res = new Integer[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextInt();
            }
            return res;
        }

        void print(Integer[] n) {
            if (n.length == 0) return;
            for (int i = 0; i < n.length - 1; i++) {
                io.print(n[i] + " ");
            }
            io.println(n[n.length - 1]);
        }

        void reversePrint(Integer[] n) {
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

    static class Util {
        public static List<Integer> getPrimeNumbers(Integer n) {
            if (n < 2) return Collections.emptyList();

            var isComposite = new boolean[n + 1];

            for (int j = 2 * 2; j <= n; j += 2) isComposite[j] = true;

            for (int i = 3; i * i <= n; i += 2) {
                if (isComposite[i]) continue;
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(2);
            for (int i = 3; i <= n; i += 2) {
                if (!isComposite[i]) list.add(i);
            }

            return list;
        }
    }
}

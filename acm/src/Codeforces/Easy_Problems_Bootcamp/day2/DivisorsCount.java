//package Codeforces.Easy_Problems_Bootcamp.day2;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class DivisorsCount {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !DivisorsCount.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int N = io.nextInt();
            new DivisorsCount().solution(N);
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

    private int powCount(int n, int d) {
        int c = 0;
        while (n % d == 0) {
            ++c;
            n /= d;
        }
        return c;
    }

    private int divCount(int n) {
        int c = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) c += 2;
        }

        if (sqrt * sqrt == n) --c;
        return c;
    }

    // 18 = 2 * 3^2 = 1,  2,  3,  6,  9,  18
    // 20 = 2^2 * 5 = 1,  2,  4,  5, 10,  20
    // 25 = 5^2     = 1,  5, 25
    // 23 = 23^1    = 1, 23
    public void solution(int n) {
        var divisorCount = new int[n + 1];
        divisorCount[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (divisorCount[i] != 0) {
                continue;
            }
            for (int j = i; j <= n; j += i) {
                int divCount = powCount(j, i) + 1;
                if (divisorCount[j] == 0) {
                    divisorCount[j] = divCount;
                } else {
                    divisorCount[j] *= divCount;
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += divisorCount[i];
        }

        io.println(sum);
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
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }

        int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
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

        void print(List<Integer> n) {
            if (n.size() == 0) return;
            for (int i = 0; i < n.size() - 1; i++) {
                io.print(n.get(i) + " ");
            }
            io.println(n.get(n.size() - 1));
        }
    }
}

/*
n=int(input())
c=0
for i in range(1, n+1):
    c += (n//i)
print(c)
 */

/*
n = int(input())
d = [1] * (n + 1)

for i in range(2, n + 1):
  for j in range(i, n + 1, i):
    d[j] += 1

print(sum(d) - 1)
 */
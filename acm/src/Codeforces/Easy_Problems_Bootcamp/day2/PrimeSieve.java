package Codeforces.Easy_Problems_Bootcamp.day2;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class PrimeSieve {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !PrimeSieve.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int N = io.nextInt();
            new PrimeSieve().solution(N);
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

    public void solution(int n) {
        var composites = new boolean[n + 1];
        //Arrays.fill(composites, true);

        //composites[0] = composites[1] = true;
        //int sqrt = (int) Math.sqrt(n);
        //int sqrt = (int) StrictMath.sqrt(n);
        for (int i = 2; i * i <= n; i++) {
            if (!composites[i]) {
                // so i is prime, now cross all multiple of it
                for (int j = i * i; j <= n; j += i) {
                    composites[j] = true;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!composites[i]) primeList.add(i);
        }

        io.println(primeList.size());
        io.print(primeList);
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
    int count = 0;
    StringBuilder sb = new StringBuilder();
    boolean[] primes = new boolean[n+1];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;
    for(int i = 2;(long)i*i<=n;i++){
        if(primes[i]){
            for(int j = 2*i;j <= n;j+=i){
                primes[j] = false;
            }
        }
    }
    for(int i = 1;i<=n;i++){
        if(primes[i]){
            count++;
            sb.append(i+" ");
        }
    }
    System.out.println(count);
    System.out.println(sb);
 */
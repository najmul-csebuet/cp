package Codeforces.Easy_Problems_Bootcamp.day2;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Equation {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Equation.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int N = io.nextInt();
            new Equation().solution(N);
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
        for (int c1 = 4; ; ++c1) {
            if (!isComposite(c1)) continue;
            if (!isComposite(n + c1)) continue;
            io.println((n + c1) + " " + c1);
            break;
        }
    }

    private boolean isComposite(int N) {
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (N % i == 0) return true;
        }
        return false;
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


/*
n = int(input())
print(9*n, 8*n)
 */

/*
n=int(input())
if n%2==0:
    print(n+4,4)
else:
    print(n+9,9)
 */

/*
n = int(input())
if n == 1:
    print(9, 8)
else:
    print(3 * n, 2 * n)
 */

/*
n = int(input())
if n & 1 == 0:
  print(4 + n, 4)
else:
  print(9 + n, 9)
 */
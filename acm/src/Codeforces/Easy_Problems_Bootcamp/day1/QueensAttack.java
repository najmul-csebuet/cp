package Codeforces.Easy_Problems_Bootcamp.day1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class QueensAttack {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !QueensAttack.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int N = io.nextInt();
            int Q = io.nextInt();
            List<Position> list = new ArrayList<>();
            for (int i = 0; i < Q; i++) {
                int x = io.nextInt();
                int y = io.nextInt();
                list.add(new Position(x, y));
            }
            new QueensAttack().solution(list, N);
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

    public void solution(List<Position> list, int N) {
        var rows = new boolean[N + 1];
        var cols = new boolean[N + 1];
        var leftDiagonals = new boolean[2 * N];
        var rightDiagonals = new boolean[2 * N];

        for (int i = 0; i < list.size(); i++) {
            Position p = list.get(i);
            int leftDiagonal = p.x + p.y - 1;
            int rightDiagonal = p.x + N - p.y;
            if (rows[p.x] || cols[p.y] || leftDiagonals[leftDiagonal] || rightDiagonals[rightDiagonal]) {
                io.println("NO");
            } else {
                io.println("YES");
                rows[p.x] = true;
                cols[p.y] = true;
                leftDiagonals[leftDiagonal] = true;
                rightDiagonals[rightDiagonal] = true;
            }
        }
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
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

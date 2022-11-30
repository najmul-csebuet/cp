package Codeforces.Easy_Problems_Bootcamp.day2;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Mountainpeaks {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Mountainpeaks.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int[] H = new int[io.nextInt()];
            for (int i = 0; i < H.length; ++i) H[i] = io.nextInt();

            new Mountainpeaks().solution(H);
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

    public void solution(int[] H) {
        // chk if there are no challenging peak
        var peaks = new boolean[H.length];
        int count = 0;
        for (int i = 1; i < H.length - 1; i++) {
            if (H[i - 1] < H[i] && H[i] > H[i + 1]) {
                ++count;
                peaks[i] = true;
            }
        }

        if (count == 0) {
            io.println(0);
            return;
        }

        int l = 0;
        for (int i = 0; i < peaks.length; i++) {
            ++l;
            if (peaks[i]) {
                break;
            }
        }

        int r = 0;
        for (int i = peaks.length - 1; i >= 0; i--) {
            ++r;
            if (peaks[i]) {
                break;
            }
        }

        int minGroupLength = Math.min(l, r);
        for (; minGroupLength <= peaks.length; minGroupLength++) {
            if (peaks.length % minGroupLength != 0) continue;

            boolean found = false;
            for (int i = 0; i < peaks.length; i += minGroupLength) {
                found = false;
                for (int j = 0; j < minGroupLength; j++) {
                    if (peaks[i + j]) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    // uhu this group length is not good, try to increase it
                    break;
                }
            }

            if (found) {
                io.println(peaks.length / minGroupLength);
                return;
            }
        }

        io.println(0);
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

package Codeforces.Easy_Problems_Bootcamp.day1;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class PhoneNumbers {
    public static FastIO io;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !PhoneNumbers.class.getPackage().getName().isEmpty();
        io = new FastIO(fileInOut);

        int totalTC = fileInOut ? io.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int n = io.nextInt();
            String digits = io.next();
            new PhoneNumbers().solution(digits);
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

    public void solution(String digits) {
        int count8 = 0;
        for (char ch : digits.toCharArray()) {
            if (ch == '8') ++count8;
        }
        if (count8 == 0) {
            io.println(0);
            return;
        }

        int count = 0;
        int len = digits.length() - count8;
        while (count8 > 0 && len >= 10) {
            ++count;
            --count8;
            len -= 10;
        }

        if(count8 > 0 && count8 + len >= 11) {
            ++count;
            count8 -= (11 - len);
        }

        count += (count8 / 11);
        io.println(count);
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
#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, tot = 0, eight = 0;
    cin >> n;
    string str;
    cin >> str;
    for (int i = 0; i < n; i++) {
        if (str[i] == '8') eight++;
        else tot++;
    }
    int ans = 0;
    while (tot > 0 || eight > 0) {
        if (eight == 0) break;
        if (eight + tot < 11) break;
        int ge = min(tot, 10);
        tot -= ge;
        eight -= (11 - ge);
        ans++;
    }

    cout << ans << "\n";

    return 0;
}
 */
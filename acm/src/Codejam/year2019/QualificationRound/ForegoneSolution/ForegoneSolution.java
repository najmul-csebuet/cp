package Codejam.year2019.QualificationRound.ForegoneSolution;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        //Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //out = new PrintWriter(new BufferedOutputStream(System.out), true);
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(Solution.class.getResourceAsStream("in.txt"))));
        out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")), true);

        int testcaseCount = sc.nextInt();

        for (int i = 1; i <= testcaseCount; i++) {

            solve(i, sc.next());
        }

        out.close();

        byte[] f1 = new byte[100000];
        InputStream ansStream = Solution.class.getResourceAsStream("ans.txt");
        ansStream.read(f1);

        byte[] f2 = Files.readAllBytes(Paths.get("output.txt"));

        System.out.println("Sample test cases passed ? => " + Arrays.equals(f1, f2));
    }

    public static void solve(int caseNumber, String N) {

        String first = "";
        String second = "";

        for (int i = N.length() - 1; i >= 0; i--) {

            if (N.charAt(i) != '4') {
                first = N.charAt(i) + first;
                second = "0" + second;
                continue;
            }

            first = "3" + first;
            second = "1" + second;
        }

        second = second.replaceFirst("^0+(?!$)", "");

        out.printf("Case #%d: %s %s\n",caseNumber, first, second);
    }
}

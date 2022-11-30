package Codeforces.Practice.Adhoc.InsomniaCure;

import java.io.*;
import java.util.*;

public class InsomniaCure {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = InsomniaCure.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? InsomniaCure.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int k = sc.nextInt();
            int l = sc.nextInt();
            int m = sc.nextInt();
            int n = sc.nextInt();
            int d = sc.nextInt();
            new InsomniaCure().solve(k,l,m,n,d);
        }

        if (fileInOut) {
            verify(InsomniaCure.class.getResource("ans.txt").getFile());
        }
    }

    public static void verify(String ansFile) throws IOException {

        String outputFile = "out.txt";

        BufferedReader reader1 = new BufferedReader(new FileReader(ansFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(outputFile));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        boolean areEqual = true;
        int lineNum = 1;

        while (line1 != null || line2 != null) {

            if (line1 == null || line2 == null) {

                areEqual = false;
                break;
            } else if (!line1.equals(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if (areEqual) {

            System.out.println("All Test Cases Passed !");
        } else {

            System.out.println("Output differ at line " + lineNum);
            System.out.println("ans.txt has " + line1 + " and out.txt has " + line2 + " at line " + lineNum);
        }

        reader1.close();
        reader2.close();
    }

    public void solve(int k, int l, int m, int n, int d) {

        int sum = 0;
        int ar[] = {k,l,m,n};

        for (int i = 0; i < ar.length; i++) {
            sum += (d / ar[i]);
        }

        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                sum -= (d / lcm(ar[i], ar[j]));
            }
        }

        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                for (k = j + 1; k < ar.length; k++) {
                    sum += (d / lcm(new int[]{ar[i], ar[j], ar[k]}));
                }
            }
        }

        sum -= (d / lcm(new int[]{ar[0], ar[1], ar[2], ar[3]}));
        out.println(sum);
    }

    private int gcd(int a, int b) {
        if (a == 0)return b;
        return gcd(b%a, a);
    }

    private int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    private int lcm(int array[]) {
        int ans = array[0];
        for (int i = 1; i < array.length; i++) {
            ans = lcm(ans, array[i]);
        }
        return ans;
    }
}

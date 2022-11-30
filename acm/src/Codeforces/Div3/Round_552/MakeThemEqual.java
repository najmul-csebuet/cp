package Codeforces.Div3.Round_552;

import java.io.*;
import java.util.*;

public class MakeThemEqual {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = true;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? MakeThemEqual.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int n = sc.nextInt();

            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }

            new Solution().solve(array);
        }

        if (fileInOut) {

            verify(MakeThemEqual.class.getResource("ans.txt").getFile());
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

            if(line1 == null || line2 == null) {

                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2)) {

                areEqual = false;
                break;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();

            lineNum++;
        }

        if(areEqual) {

            System.out.println("All Test Cases Passed !");
        }
        else {

            System.out.println("Output differ at line "+lineNum);
            System.out.println("ans.txt has " + line1 + " and output.txt has " + line2 + " at line " +lineNum);
        }

        reader1.close();
        reader2.close();
    }
}

class Solution {

    public static PrintWriter out;

    public void solve(int[] array) {

        Arrays.sort(array);

        int n = array.length;
        int diff = 0;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] < array[i + 1]) {
                diff = array[i+1] - array[i];
                break;
            }
        }

        if (diff == 0) {
            out.println(0);
            return;
        }

        boolean found = false;

        for (int minDiff = 1; minDiff <= diff ; minDiff++) {
            int equal = array[0] + minDiff;
            int j = 0;
            for (; j < n; j++) {

                if (array[j] + minDiff == equal || array[j] - minDiff == equal || array[j] == equal) {
                    continue;
                }
                break;
            }
            found = j == n;
            if(found) {
                out.println(minDiff);
                return;
            }
        }

        out.println(-1);
    }
}

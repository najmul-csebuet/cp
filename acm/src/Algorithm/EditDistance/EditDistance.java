package Algorithm.EditDistance;

import java.io.*;
import java.util.*;

public class EditDistance {

    int[][] dp = new int[100][100];

    public int solve(String source, String target, int sourceStart, int targetStart) {

        if (dp[sourceStart][targetStart] > 0) {
            return dp[sourceStart][targetStart];
        }

        if (source.length() == sourceStart) {
            return target.length() - targetStart;
        }

        if (target.length() == targetStart) {
            return source.length() - sourceStart;
        }

        int insertCase = solve(source, target, sourceStart, targetStart + 1) + 1;
        int deleteCase = solve(source, target, sourceStart + 1, targetStart) + 1;
        int subCost = source.charAt(sourceStart) == target.charAt(targetStart) ? 0 : 1;
        int substitutionCase = solve(source, target, sourceStart + 1, targetStart + 1) + subCost;

        int min = Math.min(Math.min(insertCase, deleteCase), substitutionCase);

        dp[sourceStart][targetStart] = min;

        return min;
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = EditDistance.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? EditDistance.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            String source = sc.next();
            String target = sc.next();
            int solve = new EditDistance().solve(source, target, 0, 0);
            out.println(solve);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(EditDistance.class.getResource("ans.txt").getFile()));
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
    }
}

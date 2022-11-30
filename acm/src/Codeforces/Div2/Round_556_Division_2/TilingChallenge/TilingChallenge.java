package Codeforces.Div2.Round_556_Division_2.TilingChallenge;

import java.io.*;
import java.util.*;

public class TilingChallenge {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = TilingChallenge.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? TilingChallenge.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int gridLength = sc.nextInt();

            char[][] grid = new char[gridLength][gridLength];

            for (int gridIndex = 0; gridIndex < gridLength; gridIndex++) {
                grid[gridIndex] = sc.next().toCharArray();
            }

            new Solution().solve(grid);
        }

        if (fileInOut) {

            verify(TilingChallenge.class.getResource("ans.txt").getFile());
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
}

class Solution {

    public static PrintWriter out;

    public void solve(char[][] grid) {

        for (int row = 1; row < grid.length - 1; row++) {

            for (int column = 1; column < grid.length - 1; column++) {

                if (    grid[row - 1][column] == '.' &&
                        grid[row][column] == '.' &&
                        grid[row + 1][column] == '.' &&
                        grid[row][column - 1] == '.' &&
                        grid[row][column + 1] == '.') {

                    grid[row - 1][column] = '#';
                    grid[row][column] = '#';
                    grid[row + 1][column] = '#';
                    grid[row][column - 1] = '#';
                    grid[row][column + 1] = '#';
                }
            }
        }

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {

                if (grid[row][column] == '.'){
                    out.println("NO");
                    return;
                }
            }
        }

        out.println("YES");
    }
}

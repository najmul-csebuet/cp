package Codejam.year2019.QualificationRound.YouCanGoYourOwnWay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    static boolean[][] grid;
    static Stack<Character> path;
    static boolean ansFound;

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testcaseCount = sc.nextInt();

        for (int i = 1; i <= testcaseCount; i++) {

            int N = sc.nextInt();
            String P = sc.next();

            System.out.printf("Case #%d: ", i);
            for (int j = 0; j < P.length(); j++) {
                System.out.print(P.charAt(j) == 'E' ? 'S' : 'E');
            }
            System.out.println();
            /*grid = new boolean[N][N];
            path = new Stack<>();
            ansFound = false;

            int x = 0;
            int y = 0;

            grid[0][0] = true;

            for (int k = 0; k < 2 * N - 2; k++) {

                if (P.charAt(k) == 'E') {
                    ++y;
                } else {
                    ++x;
                }

                grid[x][y] = true;
            }

            System.out.printf("Case #%d: ", i);

            solve(0, 0, N);*/
        }
    }

    private static void solve(int i, int j, int N) {

        if (ansFound) {
            return;
        }

        if(i == N - 1 && j == N - 1) {

            ansFound = true;
            for (int k = 0; k < path.size(); k++) {
                System.out.print(path.elementAt(k));
            }
            System.out.println();
            return;
        }

        boolean willNotCrossEast = (j + 1 <= N - 1);
        boolean willNotCrossSouth = (i + 1 <= N - 1);

        if (willNotCrossEast && !(grid[i][j] && grid[i][j + 1])) {

            path.push('E');

            solve(i, j + 1, N);

            path.pop();
        }

        if (willNotCrossSouth && !(grid[i][j] && grid[i + 1][j])) {

            path.push('S');

            solve(i + 1, j, N);

            path.pop();
        }
    }
}
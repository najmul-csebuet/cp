package Codeforces.Div2.Round_556_Division_2.StockArbitraging;

import java.io.*;
import java.util.*;

public class StockArbitraging {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = StockArbitraging.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? StockArbitraging.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int r = sc.nextInt();

            int nBuyLength = n;
            int[] nBuy = new int[nBuyLength];

            for (int nBuyIndex = 0; nBuyIndex < nBuy.length; nBuyIndex++) {
                nBuy[nBuyIndex] = sc.nextInt();
            }


            int mSellLength = m;
            int[] mSell = new int[mSellLength];

            for (int mSellIndex = 0; mSellIndex < mSell.length; mSellIndex++) {
                mSell[mSellIndex] = sc.nextInt();
            }

            new Solution().solve(n, m, r, nBuy, mSell);
        }

        if (fileInOut) {

            verify(StockArbitraging.class.getResource("ans.txt").getFile());
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

    public void solve(int n, int m, int r, int[] nBuy, int[] mSell) {

        Arrays.sort(nBuy);
        Arrays.sort(mSell);

        boolean takeNoAction = true;
        for (int i = mSell.length - 1; i >= 0; i--) {
            if (nBuy[0] < mSell[i]) {
                takeNoAction = false;
                break;
            }
        }

        if (takeNoAction) {
            out.println(r);
            return;
        }

        int buyCount = r / nBuy[0];
        int total = r - nBuy[0] * buyCount + buyCount * mSell[mSell.length - 1];
        out.println(total);
    }
}

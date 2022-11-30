package Codeforces.Div3.R_555.C;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class C2 {

    public void solve(int[] ar) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        int left = 0, right = ar.length - 1;
        while (left <= right) {

            Integer lastAdded = arrayList.size() > 0 ? arrayList.get(arrayList.size() - 1) : 0;

            if (left == right) {
                if (lastAdded < ar[left]) {
                    arrayList.add(ar[left]);
                    ans.append('L');
                    ++left;
                }
                break;
            }

            if (ar[left] < ar[right]) {
                if (lastAdded < ar[left]) {
                   arrayList.add(ar[left]);
                   ans.append('L');
                   ++left;
               }
               else if (lastAdded < ar[right]) {
                   arrayList.add(ar[right]);
                   ans.append('R');
                   --right;
               }
               else
                   break;
            }
            else if (ar[left] > ar[right]) {
                if (lastAdded < ar[right]) {
                    arrayList.add(ar[right]);
                    ans.append('R');
                    --right;
                }
                else if (lastAdded < ar[left]) {
                    arrayList.add(ar[left]);
                    ans.append('L');
                    ++left;
                }
                else
                    break;
            }
            else {
                int lc = 0, rc = 0;
                for (int i = left; i < right; i++) {
                    if (ar[i] < ar[i+1])++lc;
                    else break;
                }
                for (int i = right; i > left; i--) {
                    if (ar[i] < ar[i-1])++rc;
                    else break;
                }
                if (lc >= rc) {

                    if (lastAdded < ar[left]) {
                        arrayList.add(ar[left]);
                        ans.append('L');
                        ++left;
                    }
                    else break;
                }
                else {
                    if (lastAdded < ar[right]) {
                        arrayList.add(ar[right]);
                        ans.append('R');
                        --right;
                    }
                    else break;
                }
            }
        }

        out.println(ans.length());
        out.println(ans);
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = C2.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C2.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int arLength = sc.nextInt();
            int[] ar = new int[arLength];

            for (int arIndex = 0; arIndex < ar.length; arIndex++) {
                ar[arIndex] = sc.nextInt();
            }

            new C2().solve(ar);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(C2.class.getResource("ans.txt").getFile()));
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

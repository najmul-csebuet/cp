package Codeforces.Practice.DP;

import java.io.*;
import java.util.*;

public class CutRibbon {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = CutRibbon.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? CutRibbon.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            new CutRibbon().solve(N, a, b, c);
        }

        if (fileInOut) {
            verify(CutRibbon.class.getResource("ans.txt").getFile());
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

    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    private int ans(int n, int a, int b, int c) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        hashMap.put(0, 0);
        arrayList.add(0);

        for (int i = 0; i < arrayList.size(); i++) {

            int num = arrayList.get(i);
            if (num + a > n && num + b > n && num + c > n) {
                continue;
            }

            Integer numValue = hashMap.get(num);

            if (num + a <= n) {
                hashMap.put(num + a, numValue + 1);
                arrayList.add(num + a);
            }

            if (num + b <= n) {
                hashMap.put(num + b, numValue + 1);
                arrayList.add(num + b);
            }

            if (num + c <= n) {
                hashMap.put(num + c, numValue + 1);
                arrayList.add(num + c);
            }
        }

        return hashMap.getOrDefault(n, 0);
    }

    public void solve(int n, int a, int b, int c) {
//        int max = ans(n,a,b,c);//pieceCount(n, a, b, c);
        int max = pieceCount(n, a, b, c);
        out.println(max != -1 ? max : 0);
    }

    private int pieceCount(int n, int a, int b, int c) {

        if (n == 0) {
            return 0;
        }

        if (n < a && n < b && n < c) {
            return  -1;
        }

        if(hashMap.containsKey(n)) {
            return hashMap.get(n);
        }

        int A = 1 + pieceCount(n - a, a, b, c);
        int B = 1 + pieceCount(n - b, a, b, c);
        int C = 1 + pieceCount(n - c, a, b, c);

        int max = Math.max(Math.max(A, B), C);

        //System.out.println(n + ", max:" + max + ", A:"+ A + ", B:" + B + ", C:" + C);

        hashMap.put(n, max != 0 ? max : -1);
        return hashMap.get(n);
    }
}

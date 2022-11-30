package Codeforces.Practice.Adhoc;

import java.io.*;
import java.util.*;

public class TPrimes {

    static HashMap<Integer, Boolean> primeList;

    static int countPrimesUpperBound(int max) {
        return max > 1 ? (int)(1.25506 * max / Math.log((double)max)) : 0;
    }

    // Return primes less than limit
    static HashMap<Integer, Boolean> generatePrimes(int limit) {
        final int numPrimes = countPrimesUpperBound(limit);
//        ArrayList<Integer> primes = new ArrayList<Integer>(numPrimes);
        HashMap<Integer, Boolean> map = new HashMap<>();
        boolean [] isComposite    = new boolean [limit];   // all false
        final int sqrtLimit       = (int)Math.sqrt(limit); // floor
        for (int i = 2; i <= sqrtLimit; i++) {
            if (!isComposite [i]) {
//                primes.add(i);
                map.put(i, true);
                for (int j = i*i; j < limit; j += i) // `j+=i` can overflow
                    isComposite [j] = true;
            }
        }
        for (int i = sqrtLimit + 1; i < limit; i++)
            if (!isComposite [i]) {
                map.put(i, true);
//                primes.add(i);
            }

//        return primes;
        return map;
    }

    public void solve(long a) {

        if(a == 1) {
            out.println("NO");
            return;
        }

        int sqrt = (int) Math.sqrt(a);
        if ((sqrt != 2 && sqrt%2 == 0) || 1l*sqrt*sqrt != a) {
            out.println("NO");
            return;
        }

        Boolean orDefault = primeList.getOrDefault(sqrt, false);
        if (orDefault) {
            out.println("YES");
        }
        else {
            out.println("NO");
        }
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = TPrimes.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? TPrimes.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        TPrimes tPrimes = new TPrimes();

        primeList = TPrimes.generatePrimes(1000000);

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                long a = sc.nextLong();
                tPrimes.solve(a);
            }
        }

        if (fileInOut) {
            verify(TPrimes.class.getResource("ans.txt").getFile());
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

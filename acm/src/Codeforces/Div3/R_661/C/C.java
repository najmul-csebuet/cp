package Codeforces.Div3.R_661.C;import Common.Verifier;

import java.io.*;
import java.util.*;

public class C {

    public void solution(int[] weights) {

        int n = weights.length;
        if (n < 2) {
            out.println(0);
            return;
        }

        Arrays.sort(weights);
        int ans = 0;
        int minS = weights[0] + weights[1];
        int maxS = weights[n - 2] + weights[n - 1];

        for (int s = minS; s <= maxS; s++) {

            int t = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int a : weights)map.put(a, map.getOrDefault(a, 0) + 1);

            for (int i = 0; i < weights.length; i++) {
                if (map.get(weights[i]) == 0)continue;
                if (s <= weights[i])break;

                int i1 = s - weights[i];
                map.put(weights[i], map.get(weights[i]) - 1);

                if (map.getOrDefault(i1, 0) > 0) {
                    ++t;
                    //map.put(weights[i], map.get(weights[i]) - 1);
                    map.put(i1, map.get(i1) - 1);
                }
                else {
                    map.put(weights[i], map.get(weights[i]) + 1);
                }
            }

            ans = Math.max(ans, t);
        }

        out.println(ans);
    }

    public static Scanner sc;
    public static PrintWriter out;

    static {
        boolean fileInOut = C.class.getPackage() != null;
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? C.class.getResourceAsStream("in.txt") : System.in)));
        try {
            out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        boolean fileInOut = C.class.getPackage() != null;

        //int totalTestCase = fileInOut ? sc.nextInt() : 1;
        int totalTestCase = sc.nextInt();

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {
            int nnLength = sc.nextInt();
            int[] nn = new int[nnLength];

            for (int nnIndex = 0; nnIndex < nn.length; nnIndex++) {
                nn[nnIndex] = sc.nextInt();
            }

            new C().solution(nn);
        }

        if (fileInOut) {
            Verifier.verify(C.class.getResource("ans.txt").getFile());
        }
    }
}

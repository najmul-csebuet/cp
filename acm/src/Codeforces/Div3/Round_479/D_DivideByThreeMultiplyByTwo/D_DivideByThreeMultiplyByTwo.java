package Codeforces.Div3.Round_479.D_DivideByThreeMultiplyByTwo;import Common.Verifier;

import java.io.*;
import java.util.*;

public class D_DivideByThreeMultiplyByTwo {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = D_DivideByThreeMultiplyByTwo.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D_DivideByThreeMultiplyByTwo.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            
            int arrayLength = sc.nextInt();
            Long[] array = new Long[arrayLength];
            
            for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
                array[arrayIndex] = sc.nextLong();
            }
            
            new Solution().solve(array);
        }

        if (fileInOut) {
            Verifier.verify(D_DivideByThreeMultiplyByTwo.class.getResource("ans.txt").getFile());
        }
    }
}

class Solution {
    public static PrintWriter out;
    private int pow3(Long n) {
        int count = 0;
        while(n%3 == 0) {
            ++count;
            n /= 3;
        }

        return count;
    }

    public void solve(Long[] array) {

        Arrays.sort(array, (o1, o2) -> {
            int a = pow3(o1);
            int b = pow3(o2);

            if (a > b) return -1;
            if (a < b) return 1;

            return o1 - o2 < 0 ? -1 : 1;
        });

        for (int i = 0; i < array.length-1; i++) {
            out.print(array[i] + " ");
        }
        if(array.length > 0) {
            out.println(array[array.length - 1]);
        }
    }
}

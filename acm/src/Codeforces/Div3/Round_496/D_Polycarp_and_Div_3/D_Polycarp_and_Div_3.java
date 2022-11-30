package Codeforces.Div3.Round_496.D_Polycarp_and_Div_3;

import java.io.*;
import java.util.*;

public class D_Polycarp_and_Div_3 {

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = D_Polycarp_and_Div_3.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? D_Polycarp_and_Div_3.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            String s = sc.next();
            new D_Polycarp_and_Div_3().solution(s);
        }

        if (fileInOut) {
            verify(D_Polycarp_and_Div_3.class.getResource("ans.txt").getFile());
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

    public void solution(String str) {

        //str += "00";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            int sum = 0;

            for (int j = i; j < str.length() && j < i+3; j++) {

                int x = str.charAt(j) - 48;
                sum += x;

                if (x % 3 == 0 || sum % 3 == 0) {

                    ++count;
                    i = j;
                    break;
                }
            }
        }

        out.println(count);
    }
}

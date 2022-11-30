package Common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Verifier {

    public static void main(String[] args) throws IOException {
        verify();
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

    public static void verify() throws IOException {
        String[] ansFileText = Files.readAllLines(Paths.get("ans.txt")).toArray(new String[0]);
        String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
        if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
        else {
            for (int i = 0; i < ansFileText.length; i++) {
                if (i >= outFileText.length) {
                    System.out.println("<NO OUTPUT> ------> " + ansFileText[i]);
                } else if (!ansFileText[i].equals(outFileText[i])) {
                    System.out.println(outFileText[i] + " ------> " + ansFileText[i]);
                } else {
                    System.out.println(outFileText[i]);
                }
            }
        }
    }
}
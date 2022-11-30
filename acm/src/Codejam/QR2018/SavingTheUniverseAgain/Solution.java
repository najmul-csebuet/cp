package Codejam.QR2018.SavingTheUniverseAgain;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Solution.class.getResourceAsStream("in.txt");
        Scanner sc = new Scanner(inputStream);

        String curDir = new File("in.txt").getAbsolutePath();

        FileWriter fileWriter = new FileWriter(new File("output.txt"));



        int testCase = sc.nextInt();

        for (int i = 1; i <= testCase; i++) {

            fileWriter.write("Case #" + i + ": ");

            int stepCount = 0;

            int damage = sc.nextInt();
            String program = sc.next();

            fileWriter.write(program + "\n");
        }

        fileWriter.close();
    }
}
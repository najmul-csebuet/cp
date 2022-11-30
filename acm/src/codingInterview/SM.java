package codingInterview;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SM {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !SM.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? SM.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? 1 : 1;
        for (int t = 1; t <= totalTC; t++) {

            List<String> list = new ArrayList<>();
            while (sc.hasNextLine()) {
                String next = sc.nextLine();
                list.add(next);
            }
            new SM().solution(list);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(SM.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public String solution(List<String> list) {

        String st = "";

        for (int i = 0; i < list.size() - 1; i++) {
            st += (list.get(i) + ";");
        }

        if (list.size() > 1) {
            st += list.get(list.size() - 1);
        }

        out.println(st);
        return st;
    }
}

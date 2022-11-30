package Codeforces.Practice.Strings;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SinkingShip {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !SinkingShip.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? SinkingShip.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = 1;
        for (int t = 1; t <= totalTC; t++) {

            int N = sc.nextInt();
            String[] crewsNames = new String[N];
            String[] crewsTitles = new String[N];

            for (int i = 0; i < N; ++i) {
                crewsNames[i] = sc.next();
                crewsTitles[i] = sc.next();
            }
            
            new SinkingShip().solution(crewsNames, crewsTitles);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(SinkingShip.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(String[] names, String[] titles) {

        //print rats
        for (int i = 0; i < names.length; i++) if (titles[i].equals("rat")) out.println(names[i]);
        for (int i = 0; i < names.length; i++) if (titles[i].equals("woman") || titles[i].equals("child")) out.println(names[i]);
        for (int i = 0; i < names.length; i++) if (titles[i].equals("man")) out.println(names[i]);
        for (int i = 0; i < names.length; i++) if (titles[i].equals("captain")) out.println(names[i]);
    }
}

package Codeforces.Div3.Round_481.G_Petyas_Exams;

import java.io.*;
import java.util.*;

public class G_Petyas_Exams {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = G_Petyas_Exams.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? G_Petyas_Exams.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int examLength = m;
            Exam[] exams = new Exam[examLength];

            for (int examIndex = 0; examIndex < exams.length; examIndex++) {
                exams[examIndex] = new Exam();
                exams[examIndex].examIndex = examIndex + 1;
                exams[examIndex].publishDate = sc.nextInt();
                exams[examIndex].examDate = sc.nextInt();
                exams[examIndex].daysNeededForPreparation = sc.nextInt();
            }

            new G_Petyas_Exams().solution(n, m, exams);
        }

        if (fileInOut) {
            verify(G_Petyas_Exams.class.getResource("ans.txt").getFile());
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

    public void solution(int n, int m, Exam[] exams) {

        int sumOfCs = 0;
        for (int i = 0; i < m; i++) {
            if (exams[i].examDate - exams[i].publishDate < exams[i].daysNeededForPreparation) {
                out.println(-1);
                return;
            }
            sumOfCs += exams[i].daysNeededForPreparation;
        }
        if (m + sumOfCs > n) {
            out.println(-1);
            return;
        }
        int[] dayMarking = new int[n+1];

        for (int i = 0; i < m; i++) {
            dayMarking[exams[i].examDate] = m+1;
        }

        Arrays.sort(exams, (e1, e2) -> {
            if (e1.examDate <= e2.examDate)return -1;
            return +1;
        });

        for (int i = 0; i < m; i++) {

            int examIndex = exams[i].examIndex;
            int publishDate = exams[i].publishDate;
            int examDate = exams[i].examDate;
            int daysNeededForPreparation = exams[i].daysNeededForPreparation;

            for (int j = publishDate; j < examDate && daysNeededForPreparation > 0; j++) {
                if (dayMarking[j] != 0)continue;
                dayMarking[j] = examIndex;
                --daysNeededForPreparation;
            }

            if (daysNeededForPreparation != 0) {
                out.println(-1);
                return;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i < n) {
                out.print(dayMarking[i] + " ");
            } else {
                out.println(dayMarking[i]);
            }
        }
    }
}

class Exam {
    int examIndex, publishDate, examDate, daysNeededForPreparation;
}
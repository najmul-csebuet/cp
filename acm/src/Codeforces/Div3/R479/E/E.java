package Codeforces.Div3.R479.E;

import java.io.*;
import java.util.*;

public class E {

    public void solve(ArrayList[] arrayLists) {

        int count = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 1; i < arrayLists.length; i++) {

            if (map.getOrDefault(i, false)) {
                continue;
            }

            boolean allHasDegree2 = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer removed = queue.remove();
                if (arrayLists[removed].size() != 2) {
                    allHasDegree2 = false;
                }
                if (map.getOrDefault(removed, false)) {
                    continue;
                }
                map.put(removed, true);
                for (int j = 0; j < arrayLists[removed].size(); j++) {
                    queue.add((Integer) arrayLists[removed].get(j));
                }
            }
            if (allHasDegree2)++count;
        }

        out.println(count);
    }

    public static PrintWriter out;
    public static void main(String[] args) throws IOException {

        boolean fileInOut = E.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? E.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTestCase = fileInOut ? sc.nextInt() : 1;

        for (int testCaseNumber = 1; testCaseNumber <= totalTestCase; testCaseNumber++) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList[] arrayLists = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                arrayLists[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                arrayLists[u].add(v);
                arrayLists[v].add(u);
            }

            new E().solve(arrayLists);
        }

        if (fileInOut) {

            String outputFile = "out.txt";

            BufferedReader reader1 = new BufferedReader(new FileReader(E.class.getResource("ans.txt").getFile()));
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
}

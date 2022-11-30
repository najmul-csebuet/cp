package Codeforces.Div3.Round_481.F_Mentors;

import java.io.*;
import java.util.*;

public class F_Mentors {

    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = F_Mentors.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? F_Mentors.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int n = sc.nextInt();
            int k = sc.nextInt();

            int rLength = n;
            int[] r = new int[rLength];

            for (int rIndex = 0; rIndex < r.length; rIndex++) {
                r[rIndex] = sc.nextInt();
            }

            int kLength = k;
            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int kIndex = 0; kIndex < k; kIndex++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (r[x - 1] > r[y - 1]) {
                    HashSet<Integer> forX = (HashSet<Integer>) map.getOrDefault(x, new HashSet<>());
                    forX.add(y);
                    map.put(x, forX);
                }

                if (r[x - 1] < r[y - 1]) {
                    HashSet<Integer> forY = (HashSet<Integer>) map.getOrDefault(y, new HashSet<>());
                    forY.add(x);
                    map.put(y, forY);
                }
            }

            new F_Mentors().solution(n, k, r, map);
        }

        if (fileInOut) {
            verify(F_Mentors.class.getResource("ans.txt").getFile());
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

    public void solution(int n, int k, int[] R, Map<Integer, Set<Integer>> quarrelMap) {

        HashMap<Integer, Integer> numCount = new HashMap<>();

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair();
            pair.x = R[i];
            pair.y = i+1;
            pairs[i] = pair;
        }

        Arrays.sort(pairs, (a, b) -> {
            if(a.x < b.x)return -1;
            if(a.x > b.x)return +1;
            if(a.y < b.y)return -1;
            return 1;
        });

        int[] count = new int[n+1];

        for (int i = 0; i < n; i++) {

            Pair pair = pairs[i];
            HashSet<Integer> hashSet = (HashSet<Integer>) quarrelMap.getOrDefault(pair.y, new HashSet<>());
            numCount.put(pair.x, numCount.getOrDefault(pair.x, 0) + 1);
            int leftProgrammerCount = i - (numCount.get(pair.x) - 1) - hashSet.size();
            count[pair.y] = leftProgrammerCount;
        }

        for (int i = 1; i < count.length; i++) {
            if(i < count.length - 1)
                out.print(count[i] + " ");
            else
                out.println(count[i]);
            out.flush();
        }
    }
}

class Pair {
    int x,y;
}

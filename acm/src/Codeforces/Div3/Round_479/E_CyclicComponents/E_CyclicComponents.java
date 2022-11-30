package Codeforces.Div3.Round_479.E_CyclicComponents;

import java.io.*;
import java.util.*;

public class E_CyclicComponents {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = E_CyclicComponents.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? E_CyclicComponents.class.getResourceAsStream("in.txt") : System.in)));
        Solution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList[] graph = new ArrayList[n+1];

            for (int j = 1; j <= n; j++) {

                graph[j] = new ArrayList<Integer>();
            }

            while(m-- > 0) {

                int u = sc.nextInt();
                int v = sc.nextInt();

                graph[u].add(v);
                graph[v].add(u);
            }


            new Solution().solve(n, m, graph);
        }

        if (fileInOut) {

            verify(E_CyclicComponents.class.getResource("ans.txt").getFile());
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
}

class Solution {

    int cycleCount = 0;
    boolean[] visited;

    public void solve(int n, int m, ArrayList[] graph) {

        visited = new boolean[n+1];

        for (int vertex = 1; vertex <= n; vertex++) {

            if (visited[vertex]) {
                continue;
            }

            Stack<Integer> friends = new Stack<>();
            friends.push(vertex);

            boolean isCycle = true;

            while (!friends.isEmpty()) {

                Integer friend = friends.pop();
                if (visited[friend]) {
                    continue;
                }

                visited[friend] = true;

                if(graph[friend].size() != 2) {
                    isCycle = false;
                }

                for (int i = 0; i < graph[friend].size(); i++) {
                    friends.push((Integer) graph[friend].get(i));
                }
            }

            if (isCycle) {
                ++cycleCount;
            }
        }

        out.println(cycleCount);
    }

    public static PrintWriter out;
}

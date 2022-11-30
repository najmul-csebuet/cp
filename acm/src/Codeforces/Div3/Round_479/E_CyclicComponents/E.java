package Codeforces.Div3.Round_479.E_CyclicComponents;

import java.io.*;
import java.util.*;

public class E {

    public static void main(String[] args) throws IOException {

        boolean fileInOut = E.class.getPackage() != null;

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? E.class.getResourceAsStream("in.txt") : System.in)));
        ESolution.out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int testCase = fileInOut ? sc.nextInt() : 1;

        for (int i = 0; i < testCase; i++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList[] graph = new ArrayList[n+1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < m; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            new ESolution().solution(n, m, graph);
        }

        if (fileInOut) {
            verify(E.class.getResource("ans.txt").getFile());
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

class ESolution {

    public static PrintWriter out;

    int cycleCount = 0;
    boolean[] visited;

    public void solution(int n, int m, ArrayList[] graph) {

        visited = new boolean[n+1];

        for (int node = 1; node <= n; node++) {

            if(visited[node])continue;

            Stack<Integer> nodes = new Stack<>();
            nodes.push(node);

            boolean isCycle = true;

            while(!nodes.isEmpty()) {

                int poppedNode = nodes.pop();
                visited[poppedNode] = true;

                if (graph[poppedNode].size() != 2) {
                    isCycle = false;
                }

                for (int i = 0; i < graph[poppedNode].size(); i++) {
                    int neighbour = (int) graph[poppedNode].get(i);
                    if(!visited[neighbour]) {
                        nodes.push(neighbour);
                    }
                }
            }

            if (isCycle)++cycleCount;
        }

        out.println(cycleCount);
    }
}

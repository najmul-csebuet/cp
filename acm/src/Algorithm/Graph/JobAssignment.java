package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class JobAssignment {

    static ArrayList<LinkedList<Integer>> adj;
    int V;

    JobAssignment(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String[] parts = text.split(" ");

        int jobs = Integer.parseInt(parts[0]);
        int days = Integer.parseInt(parts[1]);

        JobAssignment g = new JobAssignment(jobs);

        for (int i = 0; i < days; i++) {
            String jobNumberStr = reader.readLine();
            String[] jobNumberArr = jobNumberStr.split(" ");

            int jobNumber1 = Integer.parseInt(jobNumberArr[0]);
            int jobNumber2 = Integer.parseInt(jobNumberArr[1]);

            g.addEdge(jobNumber1 - 1, jobNumber2 - 1);
        }

        if (!g.isBipartite(0))
            System.out.println(0);
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    boolean hasEdge(int u, int v) {
        LinkedList<Integer> integers = adj.get(u);
        return integers.contains(v);
    }

    boolean isBipartite(int src) {

        int[] colorArr = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        colorArr[src] = 1;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);

        while (q.size() != 0) {
            int u = q.poll();

            if (hasEdge(u, u))
                return false;

            LinkedList<Integer> list = adj.get(u);

            for (int v : list) {
                if (colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.add(v);
                } else if (colorArr[v] == colorArr[u])
                    return false;
            }
        }
        System.out.println(1);
        for (int i = 0; i < V; i++) {
            if (colorArr[i] == 1) System.out.println(1);
            else System.out.println(2);
        }
        return true;
    }
}

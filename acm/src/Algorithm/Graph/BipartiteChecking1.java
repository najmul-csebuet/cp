package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class BipartiteChecking1 {

    static ArrayList<LinkedList<Integer>> adj;
    int V;

    BipartiteChecking1(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    // Driver program to test above function
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String[] parts = text.split(" ");

        int jobs = Integer.parseInt(parts[0]);
        int days = Integer.parseInt(parts[1]);

        BipartiteChecking1 g = new BipartiteChecking1(jobs);

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

    // This function returns true if
    // graph G[V][V] is Bipartite, else false
    boolean isBipartite(int src) {
        // Create a color array to store
        // colors assigned to all vertices.
        // Vertex number is used as index
        // in this array. The value '-1'
        // of colorArr[i] is used to indicate
        // that no color is assigned
        // to vertex 'i'. The value 1 is
        // used to indicate first color
        // is assigned and value 0 indicates
        // second color is assigned.
        int colorArr[] = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;

        // Assign first color to source
        colorArr[src] = 1;

        // Create a queue (FIFO) of vertex numbers
        // and enqueue source vertex for BFS traversal
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);

        // Run while there are vertices in queue (Similar to BFS)
        while (q.size() != 0) {
            // Dequeue a vertex from queue
            int u = q.poll();

            // Return false if there is a self-loop
            if (hasEdge(u, u))
                return false;

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) {
                // An edge from u to v exists
                // and destination v is not colored
                if (hasEdge(u, v) && colorArr[v] == -1) {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.add(v);
                }

                // An edge from u to v exists and destination
                // v is colored with same color as u
                else if (hasEdge(u, v) && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can
        // be colored with alternate color
        System.out.println(1);
        for (int i = 0; i < V; i++) {
            if (colorArr[i] == 1) System.out.println(1);
            else System.out.println(2);
        }
        return true;
    }
}

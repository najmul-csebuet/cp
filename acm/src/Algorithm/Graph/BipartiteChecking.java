package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;


public class BipartiteChecking {

    final static int V = 4; // No. of Vertices

    // Driver program to test above function
    public static void main(String[] args) {

        boolean G[][] = new boolean[V][V];

        // n, m
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            G[a - 1][b - 1] = true;
        }

        BipartiteChecking bipartiteChecking = new BipartiteChecking();
        /*if (bipartiteChecking.isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");*/
        if (!bipartiteChecking.isBipartite(G, 0, n))
            System.out.println(0);
    }

    // This function returns true if
    // graph G[V][V] is Bipartite, else false
    boolean isBipartite(boolean G[][], int src, int n) {
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
            if (G[u][u] == true)
                return false;

            // Find all non-colored adjacent vertices
            for (int v = 0; v < V; ++v) {
                // An edge from u to v exists
                // and destination v is not colored
                if (G[u][v] == true && colorArr[v] == -1) {
                    // Assign alternate color to this adjacent v of u
                    colorArr[v] = 1 - colorArr[u];
                    q.add(v);
                }

                // An edge from u to v exists and destination
                // v is colored with same color as u
                else if (G[u][v] == true && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        // If we reach here, then all adjacent vertices can
        // be colored with alternate color
        System.out.println(1);
        for (int i = 0; i < n; i++) {
            if (colorArr[i] == 1) System.out.println(1);
            else System.out.println(2);
        }
        return true;
    }
}

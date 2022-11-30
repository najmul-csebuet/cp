package Algorithm.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {

    //We are assuming 0,1,2,3,4 named vertices
    private final ArrayList<ArrayList<Integer>> adjList;

    Graph(ArrayList<ArrayList<Integer>> adjList) {
        this.adjList = adjList;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(Graph.class.getResourceAsStream("in.txt"))));

        var N = sc.nextInt();
        var M = sc.nextInt();

        var adjList = new ArrayList<ArrayList<Integer>>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        while (M-- > 0) {
            var a = sc.nextInt() - 1;
            var b = sc.nextInt() - 1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        var graph = new Graph(adjList);

        boolean connected = graph.isConnected();
        System.out.println("Is graph connected: " + connected);

        var count = graph.countComponent();
        System.out.println("Connected Component: " + count);

        var hasCycle = graph.hasCycle();
        System.out.println("Graph has cycle: " + hasCycle);
    }

    public boolean isConnected() {

        var visited = new boolean[adjList.size()];
        Info info = dfs(visited, 0);
        //return info.node == adjList.size() - 1;
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    public int countComponent() {

        int count = 0;
        var visited = new boolean[adjList.size()];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(visited, i);
                ++count;
            }
        }

        return count;
    }

    public boolean hasCycle() {

        var visited = new boolean[adjList.size()];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                Info info = dfs(visited, i);
                if (info.edge >= info.node) return true;
                if (info.hasCycle) return true;
            }
        }
        return false;
    }

    private Info dfs(boolean[] added, int node) {

        var info = new Info();
        var stack = new Stack<Integer>();
        stack.push(node);
        added[node] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            info.node++;
            for (int childNode : adjList.get(currentNode)) {
                if (added[childNode]) {
                    info.hasCycle = true;
                    continue;
                }
                info.edge++;
                stack.push(childNode);
                added[childNode] = true;
            }
        }
        return info;
    }

    class Info {
        int node, edge;
        boolean hasCycle = false;
    }
}

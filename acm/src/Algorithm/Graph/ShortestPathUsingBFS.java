package Algorithm.Graph;

import Common.Graph;

import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

public class ShortestPathUsingBFS {

    private static void checkTestCases(ArrayList<Boolean> l) {

        Boolean allPassed = true;
        for (int i = 0; i < l.size(); i++) {
            if (!l.get(i)) {
                allPassed = false;
                out.println("Test Case " + (i + 1) + ": Failed");
            }
        }

        out.println(allPassed ? "All Test Cases Passed!" : "");
    }

    public static void main(String[] args) throws IOException {

        ShortestPathUsingBFS s = new ShortestPathUsingBFS();
        ArrayList<Boolean> l = new ArrayList<>();

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {4, 5}};

        l.add(s.solution(edges, 1, 5).size() - 1 == 3);
        l.add(s.solution(edges, 1, 3).size() - 1 == 1);
        l.add(s.solution(edges, 4, 1).size() - 1 == 2);

        checkTestCases(l);
    }

    public List<Integer> solution(int[][] edges, int source, int dest) {
        Graph graph = new Graph(edges);
        return graph.getShortestPathLength(source, dest);
    }
}
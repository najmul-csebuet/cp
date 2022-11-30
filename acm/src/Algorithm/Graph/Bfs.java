package Algorithm.Graph;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class Bfs {

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

        ArrayList<Boolean> l = new ArrayList<>();
        int[][] points;

        points = new int[][]{{1,7}, {1,9}, {7,8}, {9,2}, {9,3}};
        l.add(new Bfs().solution(points) == 0);
        l.add(new Bfs().solution(6, points, 1, 4) == 0);

        points = new int[][]{{1,2}, {2,3}, {3,4},};
        l.add(new Bfs().solution(points) == 0);
        l.add(new Bfs().solution(4, points, 1, 4) == 0);

        checkTestCases(l);
    }

    public int solution(int[][] points) {

        //Graph graph = new Graph(points);
        //ArrayList<Integer> path = graph.getShortestPath(1, 5);


        return 0;
    }

    public int solution(int nodeCount, int[][] points, int s, int d) {

        boolean[] visited = new boolean[nodeCount + 1];
        List<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }

        /*
        An ArrayDeque (also known as an “Array Double Ended Queue”, pronounced as “ArrayDeck”) is a special kind of a growable array that allows us to add or remove an element from both sides. An ArrayDeque implementation can be used as a Stack (Last-In-First-Out) or a Queue(First-In-First-Out).
        */

        //Assuming Directed Edge
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            adjList.get(point[0]).add(point[1]);
        }

        Queue<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(s);

        while (!integerQueue.isEmpty()) {
            Integer poll = integerQueue.poll();
            visited[poll] = true;
            out.println(poll);
            ArrayList<Integer> list = adjList.get(poll);
            for(int a : list) {
                if (visited[a])continue;
                integerQueue.add(a);
            }
        }

        //Graph graph = new Graph(points);
        //ArrayList<Integer> path = graph.getShortestPath(1, 5);


        return 0;
    }

    class Graph {

        Map<Integer, Boolean> visitedMap = new HashMap<>();
        Map<Integer, ArrayList<Node>> adjList = new HashMap<>();

        Graph(int[][] points) {

            for (int i = 0; i < points.length; i++) {

                int[] point = points[i];

                ArrayList<Node> list = adjList.getOrDefault(point[0], null);

                if (list == null) {

                    list = new ArrayList<>();
                    adjList.put(point[0], list);
                }

                list.add(new Node(point[1]));
            }
        }

        public ArrayList<Integer> getShortestPath(int s, int d) {

            Queue<Node> nodeQueue = new LinkedList<>();
            nodeQueue.add(new Node(s));

            while (!nodeQueue.isEmpty()) {

                Node currentNode = nodeQueue.poll();
                visitedMap.put(currentNode.label, true);
                out.println(currentNode.label);

                //Add all children of currentNode to queue
                ArrayList<Node> nodes = adjList.getOrDefault(currentNode.label, null);

                if (nodes == null)continue;

                for (Node node : nodes) {
                    if (visitedMap.getOrDefault(node.label, false))continue;
                    nodeQueue.add(node);
                }
            }

            return null;
        }
    }

    class Node{

        public boolean visited;
        public int label;
        //other fields

        public Node(int data){
            this.visited = false;
            this.label = data;
        }
    }
}
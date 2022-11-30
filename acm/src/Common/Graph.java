package Common;

import java.util.*;

public class Graph {

    static class Node {

        int parent = -1;
        int label = 0;
        int dist = Integer.MAX_VALUE;
        String state = "White";

        Node(int label) {
            this.label = label;
        }
    }

    Map<Integer, Node> nodeMap = new HashMap<>();
    Map<Integer, ArrayList<Node>> adjList = new HashMap<>();

    public Graph(int[][] edges) {

        //Initialize
        for (int[] edge : edges) {
            for (int a : edge) {
                if (!adjList.containsKey(a)) {
                    adjList.put(a, new ArrayList<>());
                }
                if (!nodeMap.containsKey(a)) {
                    nodeMap.put(a, new Node(a));
                }
            }
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(getNode(edge[1]));
            adjList.get(edge[1]).add(getNode(edge[0]));
        }
    }

    private Node getNode(int nodeLabel) {
        return nodeMap.get(nodeLabel);
    }

    public List<Integer> getShortestPathLength(int source, int dest) {

        Node sourceNode = getNode(source);
        sourceNode.state = "Grey";
        sourceNode.dist = 0;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(sourceNode);

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();
            currentNode.state = "Black";

            ArrayList<Node> childNodes = adjList.get(currentNode.label);
            for (int i = 0; i < childNodes.size(); i++) {
                Node childNode = childNodes.get(i);
                if (childNode.state.equals("White")) {
                    childNode.dist = currentNode.dist + 1;
                    childNode.parent = currentNode.label;
                    childNode.state = "Grey";
                    queue.add(childNode);
                }
            }
        }

        Node destNode = getNode(dest);
        List<Integer> list = new ArrayList<>();

        list.add(destNode.label);
        while (destNode.parent != -1) {
            list.add(destNode.parent);
            destNode = getNode(destNode.parent);
        }

        Collections.reverse(list);

        return list;
    }
}

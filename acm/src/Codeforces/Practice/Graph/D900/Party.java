package Codeforces.Practice.Graph.D900;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Party {

    public static Scanner sc;
    public static PrintWriter out;

    public static void main(String[] args) throws IOException {

        boolean fileInOut = !Party.class.getPackage().getName().isEmpty();
        sc = new Scanner(new BufferedReader(new InputStreamReader(fileInOut ? Party.class.getResourceAsStream("in.txt") : System.in)));
        out = new PrintWriter(new BufferedOutputStream(fileInOut ? new FileOutputStream("out.txt") : System.out), true);

        int totalTC = fileInOut ? sc.nextInt() : 1;
        for (int t = 1; t <= totalTC; t++) {
            int[] N = new int[sc.nextInt()];
            for (int i = 0; i < N.length; ++i) N[i] = sc.nextInt();

            new Party().solution(N);
        }

        if (fileInOut) {
            String[] ansFileText = Files.readAllLines(Paths.get(Party.class.getResource("ans.txt").getFile())).toArray(new String[0]);
            String[] outFileText = Files.readAllLines(Paths.get("out.txt")).toArray(new String[0]);
            if (Arrays.equals(ansFileText, outFileText)) System.out.println("ALL TEST CASES PASSED!");
            else for (int i = 0; i < ansFileText.length; i++)
                if (!ansFileText[i].equals(outFileText[i])) System.out.println("Test Case #" + (i + 1) + ": Failed");
        }
    }

    public void solution(int[] n) {

        // Build adjList
        var adjList = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n.length; i++) {
            if (n[i] < 0) {
                continue;
            }
            ArrayList<Integer> arrayList = adjList.getOrDefault(n[i] - 1, new ArrayList<>());
            arrayList.add(i);
            adjList.put(n[i] - 1, arrayList);
        }

        int maxDepth = -1;
        //var visited = new boolean[n.length];b
        for (int node = 0; node < n.length; node++) {
            //if (visited[node - 1])continue;
            int depth = getDepth(adjList, node);
            maxDepth = Math.max(depth, maxDepth);
        }

        out.println(maxDepth);
    }

    private int getDepth(HashMap<Integer, ArrayList<Integer>> adjList, int node) {

        ArrayList<Integer> arrayList = adjList.getOrDefault(node, new ArrayList<>());
        if (arrayList.isEmpty()) return 1;

        int depth = 0;

        for (int n : arrayList) {
            int d = getDepth(adjList, n) + 1;
            depth = Math.max(depth, d);
        }

        return depth;

       /* var stack = new Stack<Integer>();
        stack.push(node);
        int depth = 0;

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            ArrayList<Integer> arrayList = adjList.get(pop);

        }*/

        //return 0;
    }
}

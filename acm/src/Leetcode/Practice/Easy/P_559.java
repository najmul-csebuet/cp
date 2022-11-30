package Leetcode.Practice.Easy;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class P_559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        P_559 s = new P_559();

        l.add(s.maxDepth(null) == 0);
        //l.add(Arrays.equals(s.solution(), new int[]{));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public int maxDepth(Node root) {
        return 0;
    }
}
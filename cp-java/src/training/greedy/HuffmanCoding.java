package training.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {

    public static void main(String[] args) {
        new HuffmanCoding().solve("AABACDACA");
    }

    private void solve(String input) {

        var map = new HashMap<Character, Integer>();
        for (var ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        var pq = new PriorityQueue<Pair>();
        for (var k : map.keySet()) {
            var count = map.get(k);
            pq.add(new Pair(k + "", count));
        }

        while (pq.size() >= 2) {
            var p1 = pq.poll();
            var p2 = pq.poll();
            Pair pair;
            if (p1.ch.length() <= p2.ch.length()) {
                pair = new Pair(p1, p2);
            } else {
                pair = new Pair(p2, p1);
            }
            pq.add(pair);
        }

        var root = pq.poll();

        traverse(root, "");
    }

    private void traverse(Pair root, String code) {

        if (root.left == null && root.right == null) {
            System.out.println("Char: " + root.ch + ", code: " + code);
            return;
        }

        if (root.left != null) {
            traverse(root.left, code + "0");
        }

        if (root.right != null) {
            traverse(root.right, code + "1");
        }
    }

    static class Pair implements Comparable<Pair> {
        String ch;
        int count;

        Pair left, right;

        public Pair(String ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public Pair(Pair p1, Pair p2) {
            ch = p1.ch + p2.ch;
            count = p1.count + p2.count;
            left = p1;
            right = p2;
        }

        @Override
        public int compareTo(Pair o) {
            return count - o.count;
        }
    }
}

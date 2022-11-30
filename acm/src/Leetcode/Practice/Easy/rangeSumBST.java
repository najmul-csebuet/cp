package Leetcode.Practice.Easy;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.out;

public class rangeSumBST {

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

        rangeSumBST s = new rangeSumBST();
        ArrayList<Boolean> l = new ArrayList<>();

        //l.add(s.rangeSumBST(new int[]{}) == 0);
        //l.add(Arrays.equals(s.solution(new int[]{}), new int[] {}));

        checkTestCases(l);
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        return (L <= root.val && root.val <= R ? root.val : 0) + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
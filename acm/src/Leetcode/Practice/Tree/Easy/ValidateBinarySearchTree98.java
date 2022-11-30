package Leetcode.Practice.Tree.Easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class ValidateBinarySearchTree98 {

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        ValidateBinarySearchTree98 s = new ValidateBinarySearchTree98();

        //l.add(s.isValidBST() == 0);
        //l.add(Arrays.equals(s.isValidBST(), new int[]{));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        if (!isValidBST(root.left)) return false;
        if (!isValidBST(root.right)) return false;

        var leftMax = getMax(root.left);
        var rightMin = getMin(root.right);

        if (leftMax > root.val) return false;
        return rightMin >= root.val;
    }

    private int getMin(TreeNode root) {

        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return Math.min(getMin(root.left), getMin(root.right));
    }

    private int getMax(TreeNode root) {

        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) {
            return root.val;
        }

        return Math.max(getMin(root.left), getMin(root.right));
    }

    private class TreeNode {
        int val;
        TreeNode left, right;
    }
}
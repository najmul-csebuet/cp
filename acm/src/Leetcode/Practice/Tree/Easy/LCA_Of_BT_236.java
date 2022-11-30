package Leetcode.Practice.Tree.Easy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class LCA_Of_BT_236 {

    private TreeNode ans;

    public static void main(String[] args) throws IOException {
        List<Boolean> l = new ArrayList<>();
        LCA_Of_BT_236 s = new LCA_Of_BT_236();

        //l.add(s.lowestCommonAncestor() == 0);
        //l.add(Arrays.equals(s.solution(), new int[]{));

        if (!l.contains(false)) out.println("All Test Cases Passed.");
        else for (int i = 0; i < l.size(); i++) if (!l.get(i)) out.println("Case " + (i + 1) + ": Failed");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return ans;
    }

    private int search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;

        int mid = root.val == p.val || root.val == q.val ? 1 : 0;
        int left = search(root.left, p, q);
        int right = search(root.right, p, q);

        int check = left + mid + right;
        if (check == 2) ans = root;
        return check > 0 ? 1 : 0;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
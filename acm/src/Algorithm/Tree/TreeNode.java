package Algorithm.Tree;

public class TreeNode {

    int value;
    TreeNode left, right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.value = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.left == null) return true;
        if (root.left == null) return false;
        return root.right != null;
    }
}

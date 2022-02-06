class Solution {
    int i = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return i;
    }

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        if (lh + rh > i) {
            i = lh + rh;
        }
        if (lh > rh) {
            return lh + 1;
        } else {
            return rh + 1;
        }
    }
}

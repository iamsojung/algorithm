class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null){
            return root;
        }
        
        TreeNode tempLeftNode = root.left;
        root.left = root.right;
        root.right = tempLeftNode;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
        
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lowestCommonAncestorCalculate(root, p.val, q.val);
    }
    
    private TreeNode lowestCommonAncestorCalculate(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        } else if(root.val == p || root.val == q) {
            return root;
        } else {
            TreeNode ans1 = lowestCommonAncestorCalculate(root.left, p, q);
            TreeNode ans2 = lowestCommonAncestorCalculate(root.right, p, q);
            
            if (ans1 == null) {
                return ans2;
            } else if (ans2 == null) {
                return ans1;
            }
           
           return root; 
        }
    }
        
}

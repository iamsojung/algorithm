class Solution {
    HashMap<TreeNode, Integer> hm = new HashMap<>();
public int rob(TreeNode root) {
    if(root==null) return 0;
    
    if(hm.containsKey(root))
        return hm.get(root);
    int sum = root.val;
    
    if(root.left!=null) 
        sum += rob(root.left.left)+rob(root.left.right);
    if(root.right!=null) 
        sum += rob(root.right.left)+rob(root.right.right);
    
    int csum = rob(root.left)+rob(root.right);
    hm.put(root,Math.max(sum,csum));
    return hm.get(root);  
    }
}

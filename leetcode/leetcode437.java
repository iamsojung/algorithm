class Solution {
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        count =0;
        ArrayList<Integer> DF = DFS(root,targetSum);
        return count;
    }
    
    public ArrayList<Integer> DFS(TreeNode root,int targetSum){
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> left = DFS(root.left,targetSum);
        ArrayList<Integer> right = DFS(root.right,targetSum);
        for(int i=0;i<left.size();i++){
            if(root.val + left.get(i)==targetSum){
                count++;
            }
            left.set(i,left.get(i) + root.val);
        }
        if(root.val == targetSum){
            count++;
        }
        left.add(root.val);
        for(int i=0;i<right.size();i++){
            if(root.val + right.get(i)==targetSum){
                count++;
            }
            left.add(right.get(i) + root.val);
        }
        return left;
    }
}

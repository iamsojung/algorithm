class Solution {
    public int uniquePaths(int m, int n) {
        return totalWays(0,0,m,n,new HashMap<String,Integer>());
    }
    
    int totalWays(int right, int down,int row, int col, HashMap<String,Integer>map){
        
        if(right >= col || down >= row){
            return 0;
        }
        
        if(right == col-1 && down == row-1){
            return 1;
        }
        
        
        String currentKey = right + "_" + down;
        
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int moveDown = totalWays(right,down+1,row,col,map);
        int moveRight = totalWays(right+1,down,row,col,map);    
        
        map.put(currentKey,moveDown+moveRight);
        return map.get(currentKey);
        
    }
}

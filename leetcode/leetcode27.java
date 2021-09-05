       
class Solution {
    
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]=-1;
            }else{
                arr.add(nums[i]);
            }            
        }
        for(int i=0;i<arr.size();i++){
            nums[i] = arr.get(i);            
        }       
        return arr.size();
    }  
 
}

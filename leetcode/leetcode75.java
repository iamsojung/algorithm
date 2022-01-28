class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int i=0;
        int sum=0;
        while(i<nums.length){
            if(nums[i]==2){
                while(r>i && nums[r]==2) r--;
                if(r!=i) swap(nums, i, r);
            }
            if(nums[i]==0){
                while(l<i && nums[l]==0) l++;
                if(l!=i) swap(nums, i, l);
            }
            i++;
        }
    }
}

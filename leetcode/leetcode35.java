class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (right >= left) {
            mid = (right + left) / 2;
 
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
        //        mid = left;
            }
        }
        return left;
    }
}

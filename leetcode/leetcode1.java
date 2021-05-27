/*시간복잡도 O(2N), 공간복잡도 O(N)*/
class Solution {
    public int[] twoSum(int[] nums, int target) {        

        Map<Integer,Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target-nums[i];
            if(hm.containsKey(diff)&&hm.get(diff)!=i){
                return new int[]{i,hm.get(diff)};
            }

        }
      return null;
    
    }
}
/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        

        int[] answer = new int[2];

        for(int i=0;i<nums.length;i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {

                    answer[0] = i;
                    answer[1] = j;
                    
                }
            }
        }
        return answer;
    }
}
*/


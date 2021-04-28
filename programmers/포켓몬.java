import java.util.HashSet;

class Solution {
    static public int solution(int[] nums) {

        int answer = 0;

        //System.out.println(nums.length);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        if(hs.size()>nums.length/2){
            answer = nums.length/2;
        }else{
            answer = hs.size();
        }
        //System.out.println(answer);


        return answer;
    }
}

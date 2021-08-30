class Solution {

    public int[] getConcatenation(int[] nums) {

        int cnt = 0;
        int[] temp = new int[nums.length * 2];

        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];

        }
        for (int i = nums.length; i < nums.length * 2; i++) {
            temp[i] = nums[i];
            t++;
            System.out.println(temp[i]);
        }

        return temp;


    }

}

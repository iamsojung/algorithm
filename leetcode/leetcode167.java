class Solution {

    static public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {

                int sum = numbers[i] + numbers[j];
                if (target == sum) {
                    return new int[]{i+1, j+1};
                }

            }
        }
        return new int[]{0,0};
    }
}

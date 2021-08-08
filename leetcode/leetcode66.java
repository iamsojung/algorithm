class Solution {
    
    public int[] plusOne(int[] digits) {

        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                digits[i]++;
                return digits;
            }            
            digits[i] = 0;
        }

        int[] ansArray = new int[length+1];
        ansArray[0] = 1;
        
        return ansArray;
    }
}

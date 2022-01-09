class Solution {
    public int maxArea(int[] height) {
    int sum = Integer.MIN_VALUE;
    int start = 0;
    int end = height.length - 1;
    
    while(start < end) {
        int tempSum = Math.min(height[start], height[end]) * (end - start);
        
        sum = tempSum > sum ? tempSum : sum;
        
        if(height[start] > height[end]) {
            end--;
        } else {
            start++;
        }
    }
    return sum;
    }
}

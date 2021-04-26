class Solution {    
    public boolean solution(int x) {
        boolean answer = true;
        String temp = Integer.toString(x);
        String[] arr = temp.split("");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println(sum);
        if (x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        System.out.println(answer);
        return answer;
    }
}

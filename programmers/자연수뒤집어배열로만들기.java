class Solution {
        static public int[] solution(long n) {

        String temp = Long.toString(n);
        
        String[] arr = temp.split("");
        
        int[] answer = new int[temp.length()];
        
        for(int i = temp.length()-1; i>=0; i--){

            answer[temp.length()-i-1] = Integer.parseInt(arr[i]);

        }

        return answer;
    }
}

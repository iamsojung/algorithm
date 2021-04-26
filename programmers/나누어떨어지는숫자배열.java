import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                array.add(arr[i]);
            }
        }
        answer = new int[array.size()];
        for(int j=0;j<array.size();j++){
            answer[j] = array.get(j);
        }Arrays.sort(answer);
        if(answer.length==0){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}

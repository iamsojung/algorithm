import java.util.*;

class Solution {
    
    static public int solution(int[] citations) {

        int answer= 0;
        Arrays.sort(citations);
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < 10000; i++) {
            answer = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=i){
                    answer++;
                }else{
                    continue;
                }
            }
            if(answer>=i){
                ans = Math.max(ans,i);
            }
        }
        //System.out.println(ans);
        return ans;

    }
}

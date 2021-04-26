class Solution {

    public long solution(long n) {
        long answer = 0;
        long x = 0;
        boolean flag = true;
        
        while(flag){
        
            x++;
            if(x>10000000){
                x=-1;
                flag = false;                
            }
            long temp = x*x;
            if(temp==n){
                flag = false;
            }
            
        }
        if(x!=-1){
          answer = (x+1)*(x+1);
        } else{
           answer =-1;
        }
        System.out.println(answer);
        return answer;
    }
}

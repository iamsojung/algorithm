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


/* 정말 간단한 코드 ..
class Solution {
  public long solution(long n) {
      if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
  }
}
*/

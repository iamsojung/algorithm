class Solution {
    public int solution(int n) {

        int answer = 0;

        int[] number = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            number[i] = i;
        }

        for (int i = 2; i <=n; i++) {
            if (number[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= n; j += i) {
                number[j] = 0;
            }
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) {
                answer++;
            }
        }
        return answer;
    }
}

//에라토스테네스의 체 이용

//시간초과 코드
/*
static public int solution(int n) {

        int answer = -1;

        for(int i=1;i<=n;i++){
            int input = 0;
            for(int j=1;j<=n;j++){
                int temp = i%j;
                if(temp==0){
                    input++;
                }
            }
            if(input>2){
                continue;
            }else {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
*/

class Solution {
    static public int solution(long num) {

        int answer = -1;
        boolean flag = true;

        while (flag) {

            if (num == 1)
                flag = false;

            if (answer >= 500) {
                flag = false;
            }
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
        }
        if (answer >= 500) {
            answer = -1;
        }
        System.out.println(answer);
        return answer;
    }
}

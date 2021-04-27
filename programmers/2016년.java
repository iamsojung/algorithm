class Solution {
    static public String solution(int a, int b) {

        int temp = 0;
        int[] Month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < a; i++) {
            temp += Month[i-1];
        }

       // System.out.println();
        temp = temp + b;

        //System.out.println(temp);
        int week = temp % 7;
        //System.out.println(week);

        String[] weekend = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        String answer = "";

        if (week == 0) {
            answer = weekend[6];
        } else {
            answer = weekend[week - 1];
        }
        //System.out.println(answer);
        //2월1일은 월요일
        return answer;

    }
}

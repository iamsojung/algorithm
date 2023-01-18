class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;

        for (int i = 1; i <= area; i++) {
            int x = i;
            int y = area / i;

            if (x > y)
                continue;

            if((x - 2) * (y - 2) == yellow){
                answer[0] = y;
                answer[1] = x;
                return answer;
            }

        }
        return answer;
    }
}

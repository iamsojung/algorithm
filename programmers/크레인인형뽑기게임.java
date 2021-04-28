import java.util.*;

class Solution {
    static public int solution(int[][] board, int[] moves) {

        int answer = 0;
        //가장 위에 칸 숫자 메모해주는 배열 선언
        int[] location = new int[board[0].length];
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    location[j] = i;
                }
            }
        }


        int[] stick = new int[moves.length];
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        //옮기기
        int ans = 0;
        for (int i = 0; i < moves.length; i++) {
            int moveX = moves[i] - 1;
            int x = location[moveX]; //가져올 열의 가장 위의 위치
            if (x >= location.length) {
                continue;
            }
            int temp = board[x][moveX]; //가장 위의 값 가져오기

            if(!stack.empty() && stack.peek() == temp) {
                stack.pop();
                answer++;
                answer++;

            } else {
                stack.push(temp);
            }
            location[moveX] = x + 1; //위의 값 갱신해줌
        }
        return answer;
    }

}

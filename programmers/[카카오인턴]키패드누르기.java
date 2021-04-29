import java.util.*;

class Solution {
    static public String solution(int[] numbers, String hand) {

        String answer = "";
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> rightHs = new HashSet<>();
        HashSet<Integer> leftHs = new HashSet<>();

        rightHs.add(3);
        rightHs.add(6);
        rightHs.add(9);

        leftHs.add(1);
        leftHs.add(4);
        leftHs.add(7);

        int left = 10;
        int right = 11;

        int[] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] x = {3,0, 0, 0,1, 1, 1, 2, 2, 2,3,3};
        int[] y = {1,0, 1, 2, 0, 1, 2, 0, 1, 2,0,2};

        for (int i = 0; i < numbers.length; i++) {

            if (rightHs.contains(numbers[i])) {
                sb.append("R");
                right = numbers[i];

            } else if (leftHs.contains(numbers[i])) {
                sb.append("L");
                left = numbers[i];

            } else {
                int tempX = x[left];
                int tempY = y[left];

                int temp1X = x[right];
                int temp1Y = y[right];

                int diffL = Math.abs(tempX - x[numbers[i]]) + Math.abs(tempY - y[numbers[i]]);
                int diffR = Math.abs(temp1X - x[numbers[i]]) + Math.abs(temp1Y - y[numbers[i]]);

                if (diffL > diffR) {
                    right = numbers[i];
                    sb.append("R");
                } else if (diffL < diffR) {
                    left = numbers[i];
                    sb.append("L");
                } else if (diffL == diffR) {
                    if (hand.equals("right")) {
                        right = numbers[i];
                        sb.append("R");
                    } else if(hand.equals("left")){
                        left = numbers[i];
                        sb.append("L");
                    }
                }                
            }
        }
        answer = sb.toString();

        return answer;
    }
}

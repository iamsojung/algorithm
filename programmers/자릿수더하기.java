import java.util.*;

public class Solution {
    static public int solution(int n) {
        int answer = 0;

        String temp = Integer.toString(n);
        String[] arr = temp.split("");

        for (int i = 0; i < arr.length; i++) {
            answer += Integer.parseInt(arr[i]);
        }
        System.out.println(answer);
        return answer;
    }
}

package week7;

import java.util.Stack;

public class programmers_짝지어제거하기 {

    public static void main(String[] args) {

        String s = "cdcd";
        solution(s);

    }

    static public int solution(String s) {

        int answer = -1;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(!stack.isEmpty()){
                char temp = stack.peek();
                if(temp==arr[i]){
                    stack.pop();
                }else{
                    stack.add(arr[i]);
                }
            }else{
                stack.add(arr[i]);

            }


        }
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}

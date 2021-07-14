package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] arr = input.toCharArray();
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (arr[i - 1] == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }
        System.out.println(result);

    }
}

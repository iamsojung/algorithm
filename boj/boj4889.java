package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4889 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean flag = true;
        int t = 0;
        StringBuilder sb = new StringBuilder();

        while (flag) {

            String input = br.readLine();
            if (input.startsWith("-") && input.endsWith("-")) {
                flag = false;
                break;
            }

            t++;

            char[] arr = input.toCharArray();

            Stack<Character> stack = new Stack<>();

            stack.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {

                if (!stack.isEmpty()) {
                    char tempChar = stack.peek();
                    if (arr[i] == '}' && tempChar == '{') {
                        stack.pop();
                    } else {
                        stack.push(arr[i]);
                    }
                } else {
                    stack.push(arr[i]);
                }
            }
            int ans = 0;

            while (!stack.isEmpty()) {
                if (stack.isEmpty()) {
                    break;
                } else {

                    char tempInput = stack.pop();
                    if (tempInput == '{' ) {

                        if (stack.peek() == '{') {
                            stack.pop();
                            ans++;
                        } else if (stack.peek() == '}' ) {
                            stack.pop();
                            ans = ans + 2;
                        }

                    } else if (tempInput == '}') {

                        if (stack.peek() == '}') {
                            stack.pop();
                            ans++;
                        }
                    }
                }
            }
            sb.append(t + ". " + ans);
            sb.append("\n");

            //System.out.println(ans);
        }
        System.out.println(sb.toString());

    }
}

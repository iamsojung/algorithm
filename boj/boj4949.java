package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean flag = true;

        while (flag) {
            String input = br.readLine();
            if (input.equals(".")) {
                flag = false;
            }else{
                Stack<Character> stack = new Stack<>();

                char[] arr = input.toCharArray();
                for (int i = 0; i < arr.length; i++) {

                    if (arr[i] == '(') {
                        stack.push(arr[i]);
                    } else if (arr[i] == '[') {
                        stack.push(arr[i]);
                    } else if (arr[i] == ')') {
                        if (!stack.isEmpty()) {
                            char temp = stack.peek();
                            if (temp == '(') {
                                stack.pop();
                            }else{
                                stack.push(arr[i]);
                            }
                        }else{
                            stack.push(arr[i]);
                        }
                    } else if (arr[i] == ']') {
                        if (!stack.isEmpty()) {
                            char temp = stack.peek();
                            if (temp == '[') {
                                stack.pop();
                            }else{
                                stack.push(arr[i]);
                            }
                        }else{
                            stack.push(arr[i]);
                        }
                    }
                }
                if (!stack.isEmpty()) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }

        }
    }

}

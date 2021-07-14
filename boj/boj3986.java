package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj3986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        for (int i = 0; i < N; i++) {

            Stack<Character> stack = new Stack<>();
            String temp = br.readLine();
            char[] arr = temp.toCharArray();

            for (int j = 0; j < arr.length; j++) {
                if (!stack.isEmpty()) {
                    char tempC = stack.peek();
                    if(tempC==arr[j]){
                        stack.pop();
                    }else{
                        stack.push(arr[j]);
                    }
                }else{
                    stack.push(arr[j]);
                }
            }
            if(stack.isEmpty()){
                ans++;
            }
        }

        System.out.println(ans);

    }
}

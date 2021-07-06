import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        int start = 1;


        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());

            Boolean flag = true;
            while (flag) {
                if (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                    flag = false;
                    sb.append("-\n");
                } else {
                    stack.push(start);
                    if (start == N+1) {
                        System.out.println("NO");
                        return;
                    }
                    start++;

                    sb.append("+\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int count = 0;

        while (input > 0) {
            if (input % 5 == 0) {
                input -= 5;
                count++;
            } else if (input % 3 == 0) {
                input -= 3;
                count++;
            } else if (input > 5) {
                input -= 5;
                count++;
            } else {
                count = -1;
                break;
            }

        }
        System.out.println(count);
    }
}

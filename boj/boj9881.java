import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] hills = new int[1000];

        for (int i = 0; i < N; i++) {
            hills[i] = Integer.parseInt(br.readLine());
        }
        int ans = 99999999;
        for (int i = 0; i <= 100 - 17; i++) {
            int tempAns = 0;
            for (int j = 0; j < N; j++) {
                if (hills[j] < i) {
                    tempAns += (i - hills[j]) * (i - hills[j]);
                }
                if (hills[j] > i + 17) {
                    tempAns += (hills[j] - i - 17) * (hills[j] - i - 17);
                }

            }
            ans = Math.min(ans, tempAns);
        }

        System.out.println(ans);
    }

}


package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9465ans {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];
            int ans = 0;

            for (int j = 0; j < 2; j++) {

                st = new StringTokenizer(br.readLine());

                for (int q = 1; q <= N; q++) {
                    map[j][q] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for (int j = 2; j <= N; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + map[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + map[1][j];
            }
            ans = Math.max(dp[0][N], dp[1][N]);
            System.out.println(ans);
        }


    }
}

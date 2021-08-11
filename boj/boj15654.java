package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {

    static int N, M;
    static int[] arr, ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M + 1];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
    }

    private static void dfs(int index) {

        if (index == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println();
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!visited[j]) {
                visited[j] = true;
                ans[index] = arr[j];
                dfs(index + 1);
                visited[j] = false;
            }
        }
    }
}

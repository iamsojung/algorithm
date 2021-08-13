package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15655 {

    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0);

    }

    private static void dfs(int i,int x) {

        if (i == M) {
            for (int j = 0; j < M; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println();
            return;
        }
        for (int j = x; j < N; j++) {
            if (!visited[j]) {
                visited[j] = true;
                ans[i] = arr[j];
                dfs(i + 1,j);
                visited[j]=false;
            }
        }
    }
}

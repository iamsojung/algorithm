package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15656 {

    static int N, M;
    static int[] map;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        map = new int[N];
        ans = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);
        dfs(0);

        System.out.println(sb.toString());
    }

    private static void dfs(int index) {

        if (index == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            //if(!visited[i]){
            visited[i] = true;
            ans[index] = map[i];
            dfs(index + 1);
            visited[i] = false;
            // }
        }
    }
}

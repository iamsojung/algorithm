package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj15664 {

    static int N, M;
    static int[] map;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb;
    static HashSet<String> hs = new HashSet<>();


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
        dfs(0, 0);
        System.out.println(sb.toString());
    }

    private static void dfs(int index, int x) {

        if (index == M) {
            String temp = "";
            for (int i = 0; i < M; i++) {
                temp = temp + ans[i];
            }
            boolean flag = true;
            for (int i = 0; i < M-1; i++) {
                if(ans[i]>ans[i+1])
                    flag=false;
            }
            //System.out.println("temp: " + temp);

            if (!hs.contains(temp)&&flag) {
                hs.add(temp);
                System.out.println("temp: " + temp);


                for (int j = 0; j < M; j++) {
                    sb.append(ans[j] + " ");
                }
                sb.append("\n");
            }

            return;

        }
        for (int i = x; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[index] = map[i];
                dfs(index + 1, x + 1);
                visited[i] = false;
            }
        }
    }
}

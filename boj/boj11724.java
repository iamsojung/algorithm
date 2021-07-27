package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11724 {

    static int[][] map;
    static boolean[] visited;
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N+1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            map[X][Y]=1;
            map[Y][X]=1;

        }       
        
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }

        }
        System.out.println(result);

    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if(map[start][i]==1&&!visited[i]){
                dfs(i);
            }

        }

    }

}

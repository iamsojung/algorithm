package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1260 {
    
    static int N, M, V;
    static int[][] map;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            map[X][Y]=map[Y][X]=1;            
        }

        sb.append(V);
        dfs(V);

        sb.append("\n");

        sb.append(V);
        visited = new boolean[N+1];
        bfs(V);


        System.out.println(sb.toString());
    }


    private static void dfs(int v) {

        visited[v] = true;

        for (int i = 1; i <= N; i++) {
            if(map[v][i]==1&&!visited[i]){
                sb.append(" "+i);
                dfs(i);
            }
        }
    }

    private static void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();

            for (int i = 1; i <= N; i++) {
                if(map[temp][i]==1&&!visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                    sb.append(" "+i);
                }

            }
        }
    }

}

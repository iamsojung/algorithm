package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {

    static int T, M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[X][Y] = 1;
            }
            int land = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] != 0 && !visited[j][k]) {
                        DFS(j, k);
                        land++;
                    }
                }

            }

            System.out.println(land);
        }

    }

    private static void DFS(int i, int j) {

        
        for (int dir = 0; dir < 4; dir++) {

            int tempX = i + dx[dir];
            int tempY = j + dy[dir];

            if (tempX < 0 || tempY < 0 || tempX >= M || tempY >= N)
                continue;

            if (!visited[tempX][tempY] && map[tempX][tempY] != 0) {
                visited[tempX][tempY] = true;
                DFS(tempX, tempY);
            }

        }
    }
}

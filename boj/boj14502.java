package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {

    static int N, M;
    static int[][] map;
    static int[][] copymap;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copymap = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        wall(0);
        System.out.println(answer);
    }

    private static void wall(int count) {

        if (count == 3) {
           dfs();

            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void dfs() {

        copymap = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copymap[i][j]=map[i][j];
                visited[i][j]=false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && copymap[i][j] == 2) {
                    bfs(i, j);
                }
            }
        }
        int land = 0;
       // System.out.println();
        for (int i = 0; i < N; i++) {
           // System.out.println();
            for (int j = 0; j < M; j++) {
              //  System.out.print(copymap[i][j]);
                if(copymap[i][j]==0)
                    land++;
            }
        }
        answer = Math.max(land,answer);
        //System.out.println("land"+land);

    }

    private static void bfs(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {

            Point p = q.poll();

            for (int i = 0; i < 4; i++) {

                int tempX = p.x + dx[i];
                int tempY = p.y + dy[i];

                if (tempX < 0 || tempX >= N || tempY < 0 || tempY >= M)
                    continue;

                if(copymap[tempX][tempY]==1)
                    continue;

                if (!visited[tempX][tempY] && copymap[tempX][tempY] == 0) {
                    copymap[tempX][tempY] = 2;
                    q.add(new Point(tempX, tempY));
                    visited[tempX][tempY] = true;
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

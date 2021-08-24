package week8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2206 {

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(bfs(0, 0, 1,0));
    }

    private static int bfs(int X, int Y, int cnt,int drill) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(X, Y, cnt,drill));
        visited[X][Y] = 0; // 처음 공사 횟수
        while (!q.isEmpty()) {

            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1) {
                return p.cnt;
            }

            for (int i = 0; i < 4; i++) {

                int tempX = p.x + dx[i];
                int tempY = p.y + dy[i];
                int tempCnt = p.cnt;
                int tempDrill = p.drill;

                if (tempX < 0 || tempX >= N || tempY < 0 || tempY >= M)
                    continue;

                if(visited[tempX][tempY]<=tempDrill)
                    continue;

                if (map[tempX][tempY] == 0) {
                    visited[tempX][tempY] = tempDrill;
                    q.add(new Point(tempX, tempY, tempCnt + 1,tempDrill));
                }else {
                    if(tempDrill==0){
                        q.add(new Point(tempX, tempY, tempCnt + 1,tempDrill+1));
                        visited[tempX][tempY] = tempDrill+1;
                    }
                }
            }

        }
        return -1;

    }

    static class Point {
        int x;
        int y;
        int cnt;
        int drill;

        Point(int x, int y, int cnt, int drill) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.drill = drill;
        }
    }
}

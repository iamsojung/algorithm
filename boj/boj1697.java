package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1697 {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] dir = {-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

    }

    private static void bfs(int S) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(S, 0));
        visited[S] = true;

        while (!q.isEmpty()) {

            Point p = q.poll();
            if (p.X == K) {
                System.out.println(p.T);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int temp = p.X+dir[i];
                if (temp <= 100000 && temp >= 0&&!visited[temp]) {
                    visited[temp]=true;
                    q.add(new Point(temp, p.T + 1));
                }
            }
            int temp2 = p.X * 2;
            if (temp2 <= 100000 && temp2 >= 0&&!visited[temp2]) {
                visited[temp2]=true;
                q.add(new Point(temp2, p.T + 1));
            }
        }
    }

    static class Point {
        int X;
        int T;

        Point(int X, int T) {
            this.X = X;
            this.T = T;
        }
    }
}

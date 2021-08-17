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

            int tempX = p.X + 1;
            if (tempX <= 100000 && tempX >= 0&&!visited[tempX]) {
                visited[tempX]=true;
                q.add(new Point(tempX, p.T + 1));
            }
            int temp1 = p.X - 1;
            if (temp1 <= 100000 && temp1 >= 0&&!visited[temp1]) {

                visited[temp1]=true;
                q.add(new Point(temp1, p.T + 1));
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

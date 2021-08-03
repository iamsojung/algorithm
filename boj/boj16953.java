package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj17953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(A, 1));

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            long Y = temp.X;
            int cnt = temp.count;
            if (Y == B) {
                System.out.println(cnt);
                return;
            }
            long c1 = Y * 10 + 1;
            long c2 = Y * 2;
            if (c1 <= B) {
                queue.add(new Point(Y * 10 + 1, cnt + 1));
            }
            if (c2 <= B) {
                queue.add(new Point(Y * 2, cnt + 1));
            }
        }
        System.out.println(-1);
    }

    static class Point {
        long X;
        int count;

        Point(long X, int count) {
            this.X = X;
            this.count = count;
        }
    }
}

package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj9205 {

    static int t, n, X, Y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken()); //테스트케이스 개수

        for (int test = 0; test < t; test++) {

            n = Integer.parseInt(br.readLine()); //편의점의 개수
            Location[] locations = new Location[n + 2];
            int[] visited = new int[n + 2];
            Queue<Location> q = new LinkedList<Location>();
            boolean flag = false;

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                locations[i] = new Location(X, Y);
            }

            Location start = locations[0];
            Location end = locations[n + 1];
            q.add(start);

            while (!q.isEmpty()) {
                Location cur = q.poll();

                if (cur.equals(end)) {
                    flag = true;
                    break;
                }

                for (int i = 1; i < n + 2; i++) {
                    if (visited[i] == 0 && Math.abs(cur.X - locations[i].X) + Math.abs(cur.Y - locations[i].Y) <= 1000) {
                        q.add(locations[i]);
                        visited[i] = 1;
                    }

                }
            }
            if (flag) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
       }
    }

    static class Location {
        int X;
        int Y;

        Location(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }


}

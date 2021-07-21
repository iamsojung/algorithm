package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1966 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Point> queue = new LinkedList<>();
            ArrayList<Integer> arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                queue.add(new Point(temp, j));
                arr.add(temp);
            }

            int[] answer = new int[N];

            int ans = 0;
            Collections.sort(arr, Collections.reverseOrder());
            while (!queue.isEmpty()) {

                Point tempP = queue.poll();

                if (tempP.imp == arr.get(0)) {
                    ans++;
                    arr.remove(0);
                    answer[tempP.loc] = ans;

                } else {
                    queue.add(tempP);

                }
            }
            System.out.println(answer[M]);
        }
    }

    static class Point {
        int imp;
        int loc;

        Point(int imp, int loc) {
            this.imp = imp;
            this.loc = loc;
        }
    }
}

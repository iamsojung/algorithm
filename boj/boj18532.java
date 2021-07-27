package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj18352List {

    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    static boolean[] visitied;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int dist[] = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
        }

        Arrays.fill(dist, (int) 1e9);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        dist[X] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : arr.get(cur)) {
                if (dist[i] == (int) 1e9) {
                    dist[i] = dist[cur] + 1;
                    queue.offer(i);
                }

            }
        }
        //System.out.println(Arrays.toString(dist));
        int result = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == K) {
                System.out.println(i);
                result++;
            }
        }
        if (result == 0) {
            System.out.println(-1);
        }

    }
}

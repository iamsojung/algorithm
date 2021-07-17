package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj15903ans {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            priorityQueue.add(Long.parseLong(st.nextToken()));
        }
        for (int t = 0; t < M; t++) {

            long temp1 = priorityQueue.poll();
            long temp2 = priorityQueue.poll();

            priorityQueue.add(temp1 + temp2);
            priorityQueue.add(temp1 + temp2);

        }
        long sum = 0;
        for (int j = 0; j < N; j++) {

            sum = sum + priorityQueue.poll();
        }
        System.out.println(sum);
    }
}

package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //K를 N개로 만들어야함
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {

            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);

        }

        long start = 1;
        long end = max;
        long mid = 0;

        while (start <= end) {

            mid = (start + end) / 2;

            long count = 0;

            for (int i = 0; i < K; i++) {

                long temp = arr[i] / mid;
                count = count + temp;

            }
            if (count >= N) {
                start = mid + 1;
            }
            if (count < N) {
                end = mid - 1;
            }
        }
        System.out.println(start-1);


    }
}

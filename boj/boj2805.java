package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2805 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        long start = 1;
        long end = max;

        while (start<=end){
            long count = 0;
            long mid = (start+end)/2;

            for (int i = 0; i < N; i++) {

                long temp = arr[i]-mid;

                if(temp<0)
                    continue;

                count = temp+count;
            }
            if(count>=M){
                start = mid+1;
                            }
            if(count<M){
                end = mid -1;
            }

        }
        System.out.println(start-1);


    }
}

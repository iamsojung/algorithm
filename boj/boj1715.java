package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pq.add(Long.parseLong(br.readLine()));
        }
        long answer = 0;

        while (pq.size()>=2){

            long v1 = pq.poll();
            long v2 = pq.poll();

            long sum = v1+v2;
            answer = answer+sum;
            if(pq.size()>0){
                pq.add(sum);
            }
        }
        System.out.println(answer);

    }

}

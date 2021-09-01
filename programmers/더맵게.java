package week9;

import java.util.PriorityQueue;

public class programmers_더맵게 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        solution(scoville, K);

    }

    private static int solution(int[] scoville, int K) {

        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (!pq.isEmpty()) {

            int num = pq.poll();

            answer++;
            if (num >= K)
                break;
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            if (num < K) {
                int temp = pq.poll();
                //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
                int cal = num + temp * 2;
                pq.add(cal);
            }

        }
        System.out.println(answer);
        return answer;
    }
}

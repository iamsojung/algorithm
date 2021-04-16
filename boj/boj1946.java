import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int testcase = 0; testcase < T; testcase++) {

            int N = Integer.parseInt(br.readLine());

            int[] score = new int[N+1];
            int answer = 1;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int location = Integer.parseInt(st.nextToken());
                score[location] = Integer.parseInt(st.nextToken());

            }
            
//            Arrays.sort(score, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    if (o1[0] == o2[0]) {
//                        return o1[1] - o2[1];
//                    } else {
//                        return o1[0] - o2[0];
//                    }
//                }
//            });

            int temp = score[1];

            for(int i=2;i<=N;i++) {
                if (temp >= score[i]) {
                    temp = score[i];
                    answer++;
                }
            }
            System.out.println(answer);
        }

    }
}

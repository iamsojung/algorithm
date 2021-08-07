package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15649 {

    static int N, M;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //문제의 N의 값 입력받기.
        M = Integer.parseInt(st.nextToken()); //문제의 M의 값 입력받기.


        ans = new int[M]; //중복없이 선택한 M개의 숫자를 저장하기 위한 배열
        visited = new boolean[N+1]; //중복체크를 해주기 위한 배열
        dfs(0); // 선택한 숫자의 개수는 0부터 시작

        }

    private static void dfs(int index) {

        if (index == M) { //M개가 됐을때 ans에 저장해둔 M개의 숫자 출력.
            for (int i = 0; i < M; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) { //for문 돌면서 1부터 선택해준다.
            if (!visited[i]) { //중복없이 선택하므로 visited 배열을 만들어 방문하지 않은 숫자만 골라준다.
                visited[i] = true; //방문처리를 해주고,
                ans[index]=i; // 그 숫자를 ans에 넣어준다.
                dfs(index+1); // 다시 dfs 함수 호출
                visited[i] = false; //return 되고 났을때 false 해준다.
            }
        }
    }
}

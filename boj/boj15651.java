package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15651 {

    static int N, M;
    static boolean[] visited;
    static int[] ans;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken()); //문제의 N의 값 입력받기.
        M = Integer.parseInt(st.nextToken()); //문제의 M의 값 입력받기.

        ans = new int[M]; //중복없이 선택한 M개의 숫자를 저장하기 위한 배열
        visited = new boolean[N + 1]; //중복체크를 해주기 위한 배열

        dfs(0); //탐색을 시작할 숫자 start, 선택한 개수 index로 구분
        System.out.println(sb.toString());
    }

    private static void dfs(int index) {

        if (index == M) { //M개가 됐을때 ans에 저장해둔 M개의 숫자 출력.
            for (int i = 0; i < M; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int j = 1; j <= N; j++) { //중복 상관없다고 했으므로, visited체크 빼줌
            visited[j] = true;
            ans[index] = j;
            dfs(index + 1);
            visited[j] = false;
        }

    }
}

package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1759 {

    static int L, C;
    static String[] ans;
    static String[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[C];
        ans = new String[L];
        visited = new boolean[C];

        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        dfs(0, 0);
    }

    private static void dfs(int index, int start) {

        if (index == L) {
            StringBuilder sb = new StringBuilder();
            int mo = 0, ja = 0;
            for (int i = 0; i < L; i++) {
                if (ans[i].equals("a") || ans[i].equals("e") || ans[i].equals("i") || ans[i].equals("o") || ans[i].equals("u")) {
                    mo++;
                } else {
                    ja++;
                }
                sb.append(ans[i]);
            }
            if (mo >= 1 && ja >= 2) {
                System.out.println(sb);
                return;
            } else {
                return;
            }

        }
        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                ans[index] = arr[i];
                dfs(index + 1, i + 1);
                visited[i] = false;
            }

        }
    }
}

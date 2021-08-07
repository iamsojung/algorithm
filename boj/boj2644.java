package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2644Array {

    static int n,m,A,B,cnt,answer;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //전체 사람의 수 n
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        cnt = 0;
        answer = 0;

        st = new StringTokenizer(br.readLine()); //촌수를 계산해야 하는 서로 다른 두 사람의 번호
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine()); //부모 자식들 간의 관계의 개수 m

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()); //부모 자식간의 관계를 나타내는 두 번호 x,y
            int x = Integer.parseInt(st.nextToken()); //번호 x는 뒤에 나오는 정수 y의 부모 번호
            int y = Integer.parseInt(st.nextToken());
            map[x][y]=map[y][x]=1;
        }
        dfs(A);
        if(answer>0){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }

    private static void dfs(int a) {

        if(a==B){
            answer = cnt;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(map[a][i]==1&&!visited[i]){
                visited[i]=true;
                cnt++;
                dfs(i);
                visited[i]=false;
                cnt--;
            }
        }
    }
}



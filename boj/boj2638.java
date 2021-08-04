package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2638 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isAllmelt = false;
        int cnt = 0;
        while (!isAllmelt){
            visited = new boolean[N][M];
            dfs(0,0);
            isAllmelt = melting();
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean melting() {
        boolean result = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]>0){
                    if(map[i][j]>=3){
                        map[i][j] = 0;
                    }else{
                        map[i][j]=1;
                        result = false;
                    }
                }
            }
        }
        return result;

    }

    //DFS 탐색 중 다음 이동할 장소가 치즈이면 +1 해준다.
    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int tempX = x+dx[i];
            int tempY = y+dy[i];

            if(tempX>=0&&tempX<N&&tempY>=0&&tempY<M){
                if(map[tempX][tempY]==0&&!visited[tempX][tempY]){
                    dfs(tempX,tempY);
                }else if(map[tempX][tempY]>0)
                    map[tempX][tempY]+=1;
            }
        }
    }

}

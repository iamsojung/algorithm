import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16234 {

    static int N;
    static int L;
    static int R;
    static int[][] A;
    static int[][] nation;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean flag = true;
    static int answer = 0;
    static int peopleNum = 0;
    static int nationNum = 1;
    static int nationCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        nation = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //국경선을 연다
        while (flag) {

            flag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) { //한번 실행할때마다 방문배열 초기
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (visited[i][j] == false) { //방문 안한경우 국경허물수있는지 근처 탐색시
                        peopleNum = 0;
                        nationCnt = 0;
                        DFS(i, j);
                        move(); //범위 구했으면 값변경해줌.
                        nationNum++;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer - 1);
    }

    private static void DFS(int x, int y) { //dfs로 기준점으로부터 영역 구하

        visited[x][y] = true;
        nation[x][y] = nationNum;
        peopleNum += A[x][y];
        nationCnt += 1;

        for (int dir = 0; dir < 4; dir++) {

            int tempX = x + dx[dir];
            int tempY = y + dy[dir];

            if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < N) {

                if (visited[tempX][tempY] == false) {

                    int diff = Math.abs(A[tempX][tempY] - A[x][y]);

                    if (diff >= L && diff <= R) {
                        DFS(tempX, tempY);
                    }
                }

            }
        }

    }

    private static void move() {//땅값갱신

        if (nationCnt != 1) {
            int landNum = peopleNum / nationCnt;
            flag = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (nation[i][j] == nationNum) {
                        A[i][j] = landNum;
                    }
                }
            }
        }
    }
}

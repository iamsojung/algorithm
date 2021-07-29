package week4;

public class programmers_카카오프렌즈컬러링북 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int location = 0;

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture =
                {{1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};
        solution(m,n,picture);

    }

    static public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        boolean[][] visited = new boolean[m][n];

        //location = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    location = 0;
                    dfs(i, j, picture, visited);
                }
                if(location>maxSizeOfOneArea){
                    maxSizeOfOneArea = location;
                    System.out.println(location+" "+i+" "+j);

                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0]+" "+answer[1]);

        return answer;
    }

    private static void dfs(int i, int j, int[][] picture, boolean[][] visited) {

        //방문 여부 체크
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        location++;


        //상하좌우 돌면서 같은색인지 탐색한다.
        for (int k = 0; k < 4; k++) {

            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length)
                continue;

            if (picture[i][j] == picture[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny, picture, visited);
            }

        }
    }
}

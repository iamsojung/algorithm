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
}//아래는 bfs로 새로 푼 방식
/*
import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]&&picture[i][j]!=0) {
                    cnt++;
                    int temp = bfs(i, j, m, n, picture);
                    max = Math.max(temp, max);
                }

            }
        }
        //System.out.println("max : " + max);
        //System.out.println("cnt : " + cnt);


        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }

    private static int bfs(int i, int j, int m, int n, int[][] picture) {

        visited[i][j] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));

        int land = 1;

        while (!q.isEmpty()) {

            Point p = q.poll();
            int val = picture[p.x][p.y];

            for (int k = 0; k < 4; k++) {
                int tempX = p.x + dx[k];
                int tempY = p.y + dy[k];

                if (tempX < 0 || tempY < 0 || tempX >= m || tempY >= n)
                    continue;

                if (!visited[tempX][tempY] && picture[tempX][tempY] == val) {
                    visited[tempX][tempY] = true;
                    q.add(new Point(tempX, tempY));
                    land++;
                }

            }
        }
        //System.out.println(land);
        return land;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

*/

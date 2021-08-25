import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[][] map;
    static int r;
    static int c;
    static int count;
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (input[j].equals(".")) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        count = 0;

        for (int i = 0; i < r; i++) {
            dfs(i, 0);
        }

        System.out.println(count);
    }

    static boolean dfs(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;

            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if (map[nx][ny] == 0) {
                if (ny == c - 1) {
                    map[nx][ny] = 2;
                    count++;
                    return true;
                }

                map[nx][ny] = 2;
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, M, cnt = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			// st = new StringTokenizer(br.readLine());
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
				// map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = true;
		BFS(0, 0);
		System.out.println(map[N - 1][M - 1]);

	}

	static public void BFS(int x, int y) {

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));

		while (!q.isEmpty()) {

			Point p = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {

				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];

				if (nextX >= N || nextY >= M || nextX < 0 || nextY < 0) {
					continue;
				}
				if (visited[nextX][nextY] == true || map[nextX][nextY] == 0) {
					continue;
				}
				q.add(new Point(nextX, nextY));
				map[nextX][nextY] = map[p.x][p.y] + 1;
				visited[nextX][nextY] = true;

			}

		}
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

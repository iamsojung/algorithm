import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] array = new int[N][M];

/*		System.out.println("M" + M);
		System.out.println("N" + N);
		System.out.println("array.length" + array.length);
		System.out.println("array[0].length" + array[0].length);*/

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		solution(array);
	}

	static int dx[] = { -1, 0, 0, 1 };
	static int dy[] = { 0, -1, 1, 0 };

	private static void solution(int[][] array) {

		int n = array.length;
		int m = array[0].length;

		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == 1)
					queue.add(new Point(i, j));
			}
		}
			
			while(!queue.isEmpty()) {
				Point current = queue.poll();
				for (int i = 0; i < 4; i++) {
					int x = current.x + dx[i];
					int y = current.y + dy[i];

					if (-1 < x && x < n && -1 < y && y < m && array[x][y] == 0) {
						array[x][y] = array[current.x][current.y] + 1;
						queue.add(new Point(x, y));
	//1인토마토부터 큐에 넣어 검색
					}

				}
			}

			//print(array);

			int temp = array[0][0];

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[0].length; j++) {
					if (temp < array[i][j]) {
						temp = array[i][j];
					}
					if (array[i][j] == 0) {
						System.out.println("-1");
						return;
						//주변을 살폈을때 0인부분이 있으면 -1출력, 근데 다른방법이 있나?
					}
				}
			}

			System.out.println(temp - 1);
			//1인지역부터 더했으니 -1해줘야 최소날짜나옴

		}

	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}

	}

}

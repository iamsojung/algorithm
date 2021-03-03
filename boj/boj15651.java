import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15651 {

	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		arr = new int[M];

		func(0);

		System.out.println(sb);

	}

	static void func(int index) {

		if (index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append('\n');
		} else {
			for (int i = 0; i < N; i++) {
				visited[i] = true;
				arr[index] = i + 1;
				func(index + 1);
				visited[i] = false;
			}

		}
	}

}


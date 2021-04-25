import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] answer;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];

		answer = new int[M];
		nm(0,1);

		System.out.println(sb);

	}

	static void nm(int index, int start) {

		if (index == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]+" ");
			}
			sb.append('\n');
		} else {

			for (int i = start; i <= N; i++) {
				// if(visited[i]== true)
				// continue;
				visited[i] = true;
				answer[index] = i;
				nm(index + 1,i);
				visited[i] = false;

			}

		}
	}

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {
	static int N, M;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		answer = new int[M];
		nm(0, 1);

	}

	static void nm(int index, int start) {

		if (index == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			if(visited[i]== true)
				continue;
			visited[i] = true;
			answer[index] = i;
			nm(index+1,i+1);
			visited[i] = false;
		}

	}

}

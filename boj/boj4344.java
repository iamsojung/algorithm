import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		for (int t = 0; t < M; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			int avg = sum / N;
			int answer = 0;
			int cnt1 = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j] > avg) {
					cnt1++;
				}

			}

			double finalz = (double) cnt1 * 100 / (double) N;
			System.out.printf("%.3f%% \n", finalz);

		}
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도현이의 집
        int C = Integer.parseInt(st.nextToken()); // 공유기 개수
        int[] house = new int[N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        int left = 1; //최소 길이
        int right = house[N - 1] - house[0];// 최대 길이
        while (left <= right) {
            int mid = (left + right) / 2; //공유기 거리 기준
            int prevHouse = house[0]; //첫 위치에 설치
            int count = 1; //공유기 설치 개수
            for (int i = 0; i < N; i++) {
                int distance = house[i] - prevHouse;
                if (distance >= mid) { //거리차가 기준보다 이상되야 설치 가능
                    count++;
                    prevHouse = house[i];
                }
            }
            if (count >= C) { //공유기 설치가 더 많이 됬으니 간격을 넓혀서 줄여야함
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

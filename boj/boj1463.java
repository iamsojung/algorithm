import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N + 1];
        Queue<Pair> q = new LinkedList<>();
        boolean flag = false;

        q.add(new Pair(N, 0));

        while (!flag) {

            Pair temp = q.poll();
            visited[temp.N] = true;

            if (temp.N == 1) {
                //flag = true;
                System.out.println(temp.time);
                break;
            }else {

                if (temp.N % 3 == 0 && visited[temp.N / 3] == false && temp.N >= 0 && temp.N < 1000001) {
                    q.add(new Pair((temp.N / 3), temp.time + 1));
                }
                if (temp.N % 2 == 0 && visited[temp.N / 2] == false && temp.N >= 0 && temp.N < 1000001) {
                    q.add(new Pair((temp.N / 2), temp.time + 1));
                }
                if (temp.N >= 0 && visited[temp.N - 1] == false && temp.N < 1000001) {
                    q.add(new Pair((temp.N - 1), temp.time + 1));
                }
            }
        }

    }
}


class Pair {

    int N, time;

    public Pair(int N, int time) {
        this.N = N;
        this.time = time;
    }
}

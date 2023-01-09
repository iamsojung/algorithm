import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            visited[V] = true;
            queue.offer(V);

            while (!queue.isEmpty()) {
                int number = queue.poll();
                List<Node> list = graph[number];

                for (int j = 0; j < list.size(); j++) {
                    if (visited[list.get(j).index]) {
                        continue;
                    }

                    if (list.get(j).value < K) {
                        continue;
                    }

                    count++;
                    queue.offer(list.get(j).index);
                    visited[list.get(j).index] = true;
                }
            }

            sb.append(count)
              .append("\n");
        }

        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {

    static LinkedList<Node> list[];
    static int distance[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        visit = new boolean[V + 1];
        list = new LinkedList[V + 1];
        distance = new int[V + 1];

        Arrays.fill(distance, -1);

        for (int i = 1; i <= V; i++) {
            list[i] = new LinkedList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[v1].add(new Node(v2, w));
        }

        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++)
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());

    }

    public static void dijkstra(int k) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        distance[k] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visit[now.number]) {
                visit[now.number] = true;

                for (Node next : list[now.number]) {

                    if (distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) {
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {

        int number, weight;

        Node(int n, int w) {
            this.number = n;
            this.weight = w;
        }

        @Override
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}

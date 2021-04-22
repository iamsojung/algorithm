import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programmersGraph {

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(n, edge);
    }

    static public int solution(int n, int[][] edge) {

        int answer = 0;

        boolean[] visited = new boolean[n+1];
        boolean[][] map = new boolean[n + 1][n + 1];

        for (int i = 0; i < edge.length; i++) {
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> nextNodes = new ArrayList<>();
        queue.add(1);

        visited[0] = visited[1] = true;
        while (true) {

            answer = queue.size();

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int j = 1; j <= n; j++) {

                    if (!visited[j] && map[node][j]) {
                        nextNodes.add(j);
                        visited[j] = true;
                    }
                }
            }
            if (nextNodes.isEmpty()) {
                break;
            }
            queue.addAll((nextNodes));
            nextNodes.clear();

        }

        return answer;
    }

}

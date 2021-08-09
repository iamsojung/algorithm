package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {

    static int F, S, G, U, D, result;
    static boolean flag = false;
    static boolean visited[] = new boolean[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;

        //ㅇㅣ동할 수 없는 경우 "use the stairs" 출력

        bfs(S, 0); //S부터 G에 도달해야한다.

        if (flag) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }


    }

    private static void bfs(int start, int cnt) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start, cnt));
        visited[start]=true;

        while (!queue.isEmpty()) {

            Point temp = queue.poll();
            int tempN = temp.n;
            int tempCnt = temp.cnt;

            if (tempN == G) {
                //System.out.println(tempN);
                result = tempCnt;
                flag = true;
                return;
            }
            int addN = tempN + U;
            int addD = tempN - D;
            int cntPlus = tempCnt + 1;

            if(addN<=F&&!visited[addN]){
                visited[addN]=true;
                queue.add(new Point(addN, cntPlus));
            }
            if(addD>=1&&!visited[addD]){
                visited[addD]=true;
                queue.add(new Point(addD, cntPlus));
            }
        }
    }

    static class Point {
        int n;
        int cnt;

        Point(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }
}

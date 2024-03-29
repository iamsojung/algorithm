package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1261 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

        int[][] maze=new int[N][M];
        int[][] dist=new int[N][M];
        boolean[][] check=new boolean[N][M];

        int[] dx= {0,1, 0,-1};
        int[] dy= {1,0,-1,-0};

        for(int i=0;i<N;i++) {

            System.out.println(br.readLine());
            for(int j=0;j<M;j++) {
                //maze[i][j]=Integer.parseInt(st.nextToken());
               System.out.println(Integer.parseInt(st.nextToken()));
            }
        }

        Deque<Node> queue=new LinkedList<>();
        queue.addLast(new Node(0,0));
        check[0][0]=true;


        while(!queue.isEmpty()) {
            Node now=queue.pollLast();
            int x=now.x;
            int y=now.y;

            for(int i=0; i<4; i++) {
                int next_x=x+dx[i];
                int next_y=y+dy[i];

                if(next_x<0 || next_y <0 || next_x>=N || next_y>=M || check[next_x][next_y])
                    continue;
                if(maze[next_x][next_y]==0) {
                    dist[next_x][next_y]=dist[x][y];
                    queue.addLast(new Node(next_x, next_y));
                }else {
                    dist[next_x][next_y]=dist[x][y]+1;
                    queue.addFirst(new Node(next_x, next_y));
                }
                check[next_x][next_y]=true;

            }
        }
        System.out.println(dist[N-1][M-1]);
    }


}
class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}


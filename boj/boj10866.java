import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){

            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push_front")){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }else if(order.equals("push_back")){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }else if(order.equals("pop_front")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollFirst());
                }
            }else if(order.equals("pop_back")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.pollLast());
                }
            }else if(order.equals("size")){
                System.out.println(deque.size());
            }else if(order.equals("empty")){
                if(deque.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(order.equals("front")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.peekFirst());
                }
            }else if(order.equals("back")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.peekLast());
                }
            }
        }
    }

}

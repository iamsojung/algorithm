package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i=0;i<N;i++){
            deque.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Boolean flag = true;
        int start = 1;

        while (flag){

           int temp = deque.pollFirst();

            if(start%K==0){
                //System.out.println(start+" "+K+" "+start%K);
                sb.append(temp+", ");

            }else{
                deque.offerLast(temp);
            }
            start++;

            if(deque.isEmpty()){
                flag = false;
            }

        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.println(sb.toString());
    }
}

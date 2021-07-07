package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> hs = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(st.nextToken());

            int temp1 = hs.getOrDefault(temp,0);
            hs.put(temp,temp1+1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int j=0;j<M;j++){
            int temp3 = Integer.parseInt(st.nextToken());
            if(hs.get(temp3)==null){
                sb.append(0+" ");

            }else{
                sb.append(hs.get(temp3)+" ");
            }
        }
        System.out.println(sb.toString());


    }


}

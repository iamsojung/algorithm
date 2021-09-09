package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1764 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            hs.add(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            if(hs.contains(temp)){
                arr.add(temp);
                cnt++;
            }else{
                continue;
            }

        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i)+"\n");

        }
        System.out.println(sb.toString());

    }
}

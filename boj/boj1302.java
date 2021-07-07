package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hs = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int temp = hs.getOrDefault(input, 1);
            int temp1 = temp + 1;
            hs.put(input, temp1);
            max = Math.max(max, temp1);
        }
        ArrayList<String> arr = new ArrayList<>();
        Iterator<String> keys = hs.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (hs.get(key) == max) {
                arr.add(key);
            }
        }
        Collections.sort(arr);
        System.out.println(arr.get(0));
    }
}

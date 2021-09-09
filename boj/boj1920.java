package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1920 {

    public static void main(String[] args) throws IOException {

//첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
// 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {

            int target = ans[i];
            int start = 0;
            int end = N-1;
            boolean flag = false;
            while (start<=end){

                int mid = (start+end)/2;

                if(arr[mid]<target){
                    start = mid+1;
                }
                if(arr[mid]>target){
                    end = mid-1;
                }
                if(arr[mid]==target){
                    flag=true;
                    break;
                }

            }
            if(flag){
                System.out.println(1);
            }else {
                System.out.println(0);
            }


        }

    }


}

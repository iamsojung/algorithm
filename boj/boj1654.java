import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1654 {

  public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int K = Integer.parseInt(st.nextToken());
       int N = Integer.parseInt(st.nextToken());

       long[] arr = new long[K];
       long max=0;

       for(int i=0;i<K;i++){
           arr[i]=Long.parseLong(br.readLine());
           max = Math.max(max,arr[i]);

       }
       //이분탐색
       long left = 1;
       long right = max;
       while(left<=right){
           long mid = (left+right)/2;
           long sum = 0;
           for(int i=0;i<K;i++){
               sum+=(arr[i]/mid);
           }
           if(sum>=N){
               left = mid+1;
           }else{
               right = mid-1;
           }
       }
       System.out.println(right);
   }
}


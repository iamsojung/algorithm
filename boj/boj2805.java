import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left =1;
        int right =arr[n-1];
        long height =0;
        int mid =0;

        while(left <= right){
            height =0;
            mid =(left+right)/2;

            for (int i = 0; i <n ; i++) {
                if(arr[i]>=mid) {
                    height += (arr[i] -mid);
                }
            }
            if(height >= m){
                left = mid + 1;
            }else  if(height < m){
                right = mid-1;
            }
        }
        System.out.println(right);
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class b1339 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            char[] arr = input.toCharArray();
            int temp = (int)Math.pow(10,arr.length-1);
            for(int j=0;j<arr.length;j++){
                alphabet[arr[j]-'A']+=temp;
                temp/=10;
            }

        }

        Arrays.sort(alphabet);

      int index = 9;
        int sum = 0;
        for(int i=alphabet.length-1;i>=0;i--){
            if(alphabet[i]==0){
                break;
            }
            sum+=alphabet[i]*index;
            index--;

        }
        System.out.println(sum);
    }
}

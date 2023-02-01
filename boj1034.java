import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();

        int[][] table = new int[n][m];
        String[] temp = new String[n];

        for(int i=0;i<n;i++){
            temp[i] = scan.nextLine();
            for(int j=0;j<m;j++){
                table[i][j] = Integer.parseInt(temp[i].charAt(j)+"");
            }
        }

        int k = scan.nextInt();
        boolean[] check = new boolean[n];
        int max = 0;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(table[i][j]==0){
                    cnt++;
                }
            }
            if((cnt%2==k%2)&&cnt<=k){ // k번 조작해서 조건에 맞는 행이 나오는지
                check[i]=true;
            }
        }

        for(int i=0;i<n;i++){
            if(check[i]){ // 조건에 맞는 행만
                int cnt = 0;
                for(int j=0;j<n;j++){
                    if(temp[i].equals(temp[j])){ // 초기상태가 같은 행의 개수를 센다
                        cnt++;
                    }
                }
                if(max < cnt){
                    max = cnt;
                }
            }
        }
        System.out.println(max);
    }
}

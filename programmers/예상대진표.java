package week13;

public class programmers_예상대진표 {

    public static void main(String[] args) {

        int n=8;
        int a=2;
        int b=3;


        solution(n,a,b);

    }

    static public int solution(int n, int a, int b){

        int answer = 0;

        while (true){


            if(a==b) {
                break;
            }
            answer++;

            if(a%2==0){
                a = a/2;
            }else {
                a = (a+1)/2;
            }
            if(b%2==0){
                b = b/2;
            }else {
                b = (b+1)/2;
            }

        }
        System.out.println(answer);

        return answer;
    }
}

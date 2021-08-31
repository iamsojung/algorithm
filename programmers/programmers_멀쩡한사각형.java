package week9;

public class programmers_멀쩡한사각형 {

    public static void main(String[] args) {
        solution(8, 12);
    }

    static public long solution(int w, int h) {
        long answer = 1;

        long x = (long) w;
        long y = (long) h;
        long a = (long) w;
        long b = (long) h;

        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        System.out.println(a);
        answer = x * y - ((x / a) + (y / a) - 1) * a;
        System.out.println(answer);
        return answer;
    }
}


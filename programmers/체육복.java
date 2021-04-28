import java.util.HashSet;

public class test20 {

    public static void main(String[] args) {

        int n = 5; //전체 학생의 수 n 5 [1, 2, 3] [2, 3, 4] 4
        int[] lost = {1, 2, 3}; //체육복을 도난당한 학생들의 번호가 담긴 배열 lost
        int[] reserve = {2, 3, 4};// 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
        solution(n, lost, reserve);

    }

    static public int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;
        HashSet<Integer> hs = new HashSet<>();
        boolean[] arr = new boolean[n + 2];        

        for (int t = 1; t <= n; t++) {
            arr[t] = true;
        }

        for (int i = 0; i < reserve.length; i++) {
            hs.add(reserve[i]);            
        }
        
        for (int j = 0; j < lost.length; j++) {
            arr[lost[j]] = false;
            if (hs.contains(lost[j])) {
                hs.remove(lost[j]);
                arr[lost[j]] = true;
            }
        }

        for (int j = 0; j < lost.length; j++) {
            
            if (arr[lost[j]] == false) {
                if (hs.contains(lost[j] - 1)) {
                    hs.remove(lost[j] - 1);
                    arr[lost[j]] = true;
                } else if (hs.contains(lost[j] + 1)) {
                    hs.remove(lost[j] + 1);
                    arr[lost[j]] = true;
                }
            }
        }
        
        for (int k = 1; k <= n; k++) {            
            if (arr[k]) {
                answer++;
            }
        }
        System.out.println(answer);

        return answer;
    }
}

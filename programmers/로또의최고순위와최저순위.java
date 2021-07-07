package week1;

import java.util.HashSet;

public class programmers_로또의최고순위와최저순위 {

    public static void main(String[] args) {
        int[] lottos = {1,2,3,4,5,6};
        int[] win_nums= {7,8,9,10,11,12};
        solution(lottos, win_nums);
    }

    static public int[] solution(int[] lottos, int[] win_nums) {

        int[] answer = new int[2];
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<win_nums.length;i++){
            hs.add(win_nums[i]);
        }

        int ansMax = 7;
        int ansMin = 7;

        for(int j=0;j<lottos.length;j++){
            if(hs.contains(lottos[j])){
                ansMin--;
                ansMax--;
            }else if(lottos[j]==0){
                ansMax--;
            }
        }


        if(ansMax==7){
            ansMax=6;
        }
        if(ansMin==7){
            ansMin=6;
        }

        System.out.println(ansMin+" "+ansMax);
        answer[0] = ansMax;
        answer[1] = ansMin;
        return answer;
    }
}

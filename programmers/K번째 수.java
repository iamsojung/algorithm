package week2;

import java.util.Arrays;

public class K번째수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);
    }

    static public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){

            int temp = commands[i][0];
            int temp2 = commands[i][1];
            int temp3 = commands[i][2];

            int[] tempArr = new int[temp2-temp+1];

            for(int j=0;j<tempArr.length;j++){
                tempArr[j]=array[temp+j-1];
            }
            Arrays.sort(tempArr);
            answer[i] = tempArr[temp3-1];

        }

        return answer;
    }


}

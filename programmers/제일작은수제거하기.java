import java.util.*;

class Solution {
       static public int[] solution(int[] arr) {

        int[] answer;
        if(arr.length==1){
            answer = new int[1];
            answer[0]=-1;
        }else{
            answer= new int[arr.length - 1];

            ArrayList<Integer> array = new ArrayList<>();

            for (int i =0; i < arr.length; i++) {
                array.add(arr[i]);
            }
            Collections.sort(array);
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
                if (array.get(0) == arr[i]) {


                } else {
                    answer[cnt++] = arr[i];
                }
            }


        }
        
        return answer;
    }
}


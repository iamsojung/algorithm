import java.util.*;

class Solution {
    static public long solution(long n) {

        long answer = 0;

        String temp = Long.toString(n);
        String[] arr = temp.split("");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2)-Integer.parseInt(o1);
            }
        });

        String temp1 = "";
        for(int i=0;i<arr.length;i++){
            temp1 = temp1+arr[i];
        }
        //System.out.println(Integer.parseInt(temp1));
        answer = Long.parseLong(temp1);
        return answer;
    }
}

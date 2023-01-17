import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static public int[] solution(int[] progresses, int[] speeds) {

        int[] divide = new int[progresses.length];
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {

            int num = progresses[i];
            int cnt = 0;
            while (num < 100) {
                num = num + speeds[i];
                cnt++;
            }
            divide[i] = cnt;
            q.add(divide[i]);
            System.out.print(divide[i] + " ");
        }
      
        int temp = q.poll();
        int cnt = 1;
        while (!q.isEmpty()){
            int temp1 = q.poll();
            if(temp>=temp1){
                cnt++;
            }else{
                arr.add(cnt);
                cnt = 1;
                temp = temp1;
            }
        }
        arr.add(cnt);
        int[] answer = new int[arr.size()];
        
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
            System.out.println(arr.get(i));

        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {


        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int sum = numbers[i]+numbers[j];
                hs.add(sum);
                System.out.println(sum);
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(hs.size());
        Iterator<Integer> it = hs.iterator();
        while (it.hasNext()){
            arr.add(it.next());
        }
        int[] answer = new int[arr.size()];
        Collections.sort(arr);
        for(int i=0;i<answer.length;i++){
            answer[i] = arr.get(i);
            System.out.println(answer[i]);

        }

        return answer;



    }
}

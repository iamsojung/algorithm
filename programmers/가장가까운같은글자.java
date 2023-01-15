import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        String[] str = s.split("");
        int[] answer = new int[str.length];
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (hs.containsKey(str[i])) {
                answer[i] = i - hs.get(str[i]);
                hs.put(str[i], i);
            } else {
                answer[i] = -1;
                hs.put(str[i], i);
            }
        }
        return answer;
    }
}

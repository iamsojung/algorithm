import java.util.*;

class Solution {
   public int solution(int[][] sizes) {
      int answer = 0;
      int maxX = 0;
      int maxY = 0;
      for (int i = 0; i < sizes.length; i++) {
          int x = Math.max(sizes[i][0], sizes[i][1]);
          int y = Math.min(sizes[i][0], sizes[i][1]);
          maxX = Math.max(maxX, x);
          maxY = Math.max(maxY, y);
      }
      answer = maxX * maxY;
     return answer;
    }
}

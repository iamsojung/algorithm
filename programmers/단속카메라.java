import java.util.*;

class Solution {    
  
    public int solution(int[][] routes) {
        int answer = 0;
        int len = routes.length;
        List<int[]> list = new ArrayList<>();
        for(int[] route : routes) {
            list.add(route);
        }
        System.out.println("빨리 나가는 순서대로 정렬해준다."); 
        Collections.sort(list, (a,b) -> a[1] - b[1]);
        while(!list.isEmpty()) {
            System.out.println("첫 번째 차가 빠져나가는 지점을 구한다."); 
            int position = list.get(0)[1];

            System.out.println("그 지점에 카메라를 설치함으로써 더이상 고려하지 않아도 되는 차들에 대한 정보를 빼준다."); 
            for(int i = 0; i<list.size(); i++ ) {
                if(list.get(i)[0]<=position){
                    list.remove(i);
                    i--;
                } 
            }

            System.out.println("카메라가 한대 설치 되었으므로 answer를 1 키워준다."); 
            answer++;
        }
        return answer;
    }
}

import java.util.*;

class Solution {
    static public int[] solution(int N, int[] stages) {

        int t = 0;
        int temp = stages.length+1;
        double[] answer = new double[N];
        int[] ans = new int[N];
        
        Arrays.sort(stages);
        
        for(int i=0;i<N;i++){
            for(int j=t;j<stages.length;j++){
                if(stages[j]==i+1){
                    temp--;
                    answer[i]++;
                    t++;
                }else{                    
                    continue;
                }
            }
            if (answer[i] == 0 && stages.length - t == 0) {
                answer[i] = 0;
            } else {
                answer[i] = answer[i] / (stages.length - t);
            }
        }

        ArrayList<Point> arr = new ArrayList<>();
        
        for(int i=0;i<N;i++){
            arr.add(new Point(answer[i],i+1));
        }

        Collections.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Double.compare(o2.x, o1.x);
            }
        });

        for(int i=0;i<N;i++){
            ans[i]= arr.get(i).y;
        }
        return ans;
    }

    static class Point{
        double x;
        int y;

        Point(double x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

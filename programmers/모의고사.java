import java.util.*;

class Solution {
   
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4,5,5};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (arr1[i % 5] == answers[i]) {
                cnt1++;
            }
            if (arr2[i % 8] == answers[i]) {
                cnt2++;
            }
            if (arr3[i % 10] == answers[i]) {
                cnt3++;
            }

        }
        ArrayList<Point> arr = new ArrayList<>();
        arr.add(new Point(1, cnt1));
        arr.add(new Point(2, cnt2));
        arr.add(new Point(3, cnt3));

        Collections.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point s1, Point s2) {
                return s2.score - s1.score;
            }
        });

        int cnt = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(arr.get(i).score, max);

        }
        for (int i = 0; i < arr.size(); i++) {
            if (max == arr.get(i).score) {
                cnt++;
            }
        }
        answer = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            if (max == arr.get(i).score) {
                answer[i] = arr.get(i).num;
            }
        }

        return answer;
    }

    static class Point {
        int num;
        int score;

        Point(int num, int score) {
            this.num = num;
            this.score = score;
        }
    }
}


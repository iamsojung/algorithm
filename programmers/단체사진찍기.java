import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {
    
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] visited = new boolean[8];
    static String[] picture = new String[8];
    static int ans = 0;

    static public int solution(int n, String[] data) {

        int answer = 0;
        ans = 0;
        dfs(0, data);
        answer = ans;
        System.out.println(ans);

        return answer;
    }

    private static void dfs(int index, String[] data) {

        if (index == 8) {
            String str = "";
            for (int i = 0; i < picture.length; i++) {
                str = str + picture[i];
            }
            check(str,data);
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                picture[index] = friends[i];
                dfs(index + 1, data);
                visited[i] = false;
            }
        }
    }

    private static void check(String str, String[] data) {

        int flagCnt = 0;
        for (int i = 0; i < data.length; i++) {
            Boolean flag = false;
            char[] temp = data[i].toCharArray();

            char one = temp[0];
            char two = temp[2];

            int oneLoc = str.indexOf(one);
            int twoLoc = str.indexOf(two);

            int temp4 = Integer.parseInt(String.valueOf(temp[4]));

            if (temp[3] == '=') {
                if (Math.abs(oneLoc - twoLoc) - 1 == temp4) {
                    flag = true;
                }else{
                    return;
                }
            } else if (temp[3] == '<') {
                if (Math.abs(oneLoc - twoLoc) - 1 < temp4) {
                    flag = true;
                }else{
                    return;
                }

            } else if (temp[3] == '>') {
                if (Math.abs(oneLoc - twoLoc) - 1 > temp4) {
                    flag = true;
                }else {
                    return;
                }
            }
            if (flag) {
                flagCnt++;
            }

        }
        if (flagCnt == data.length) {
            ans++;
        }
    }

}

class Solution {
    static boolean solution(String s) {

        boolean answer = true;

        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == 'p') {
                p++;
            } else if (arr[i] == 'y') {
                y++;
            }
        }

        if (p == 0 && y == 0) {
            return true;
        }
        if (p == y) {
            return true;
        } else {
            return false;


        }

    }
}

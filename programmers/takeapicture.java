public class takeapicture {

    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited;
    static char[] map;
    static int answer;

    public static void main(String[] args) {

        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        solution(n, data);

    }

    static public int solution(int n, String[] data) {

        answer = 0;
        visited = new boolean[8];
        map = new char[8];

        dfs(0, n, data);

        System.out.println(answer);
        return answer;
    }

    static void dfs(int index, int n, String[] data) {

        if (index == 8) {
            answer++;
            //return;
        } else {
            for (int i = 0; i < 8; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                map[index] = friends[i];
                if (check(index + 1, n, data)) {

                    dfs(index+1, n, data);
                }

                visited[i] = false;
            }
        }
    }

    static boolean check(int index, int n, String[] data) { //조건에 맞는지 확인해봄.

        for (int i = 0; i < n; i++) {
            char[] condition = data[i].toCharArray();

            int from = -1, to = -1;
            for (int j = 0; j < index; j++) {
                if (map[j] == condition[0]) {
                    from = j;
                }
                if (map[j] == condition[2]) {
                    to = j;
                }
            }

            if (from < 0 || to < 0) {
                return true;
            }
            int gap = Math.abs(from - to) - 1;
            int len = condition[4] - '0';
            switch (condition[3]) {
                case '=':
                    if (gap != len) return false;
                    break;
                case '>':
                    if (gap <= len) return false;
                    break;
                case '<':
                    if (gap >= len) return false;
                    break;
            }
        }

        return true;
    }
}

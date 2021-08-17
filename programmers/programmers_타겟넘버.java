package week7;

public class programmers_타겟넘버 {

    static int[] numbers = {1, 1, 1, 1, 1};
    static int target = 3;

    public static void main(String[] args) {

        solution(numbers, target);
    }
    static int answer = 0;
    static private int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        System.out.println(answer);

        return answer;
    }

    private static void dfs(int[] numbers, int target, int index, int sum) {

        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        sum = sum + numbers[index];
        dfs(numbers, target, index + 1, sum);
        sum = sum - numbers[index];
        sum = sum + (-1 * numbers[index]);
        dfs(numbers, target, index + 1, sum);

    }

}

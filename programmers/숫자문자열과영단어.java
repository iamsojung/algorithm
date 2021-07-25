package week4;

public class programmers_숫자문자열과영단어 {

    public static void main(String[] args) {

        String s = "one4seveneight";
        solution(s);

    }

    static public int solution(String s) {

        int answer = 0;
        Boolean flag = true;
        while (flag) {

            s = s.replace("zero", "0");
            s = s.replace("one", "1");
            s = s.replace("two", "2");
            s = s.replace("three", "3");
            s = s.replace("four", "4");
            s = s.replace("five", "5");
            s = s.replace("six", "6");
            s = s.replace("seven", "7");
            s = s.replace("eight", "8");
            s = s.replace("nine", "9");

            if (s.matches("[+-]?\\d*(\\.\\d+)?")) {
                flag = false;
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}

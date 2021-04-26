class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String[] arr = phone_number.split("");
        for (int i = 0; i < arr.length - 4; i++) {
            arr[i] = "*";
            answer = answer + "*";
        }
        for (int i = arr.length - 4; i < arr.length; i++) {

            answer = answer + arr[i];
        }

        System.out.println(answer);
        return answer;
    }

}

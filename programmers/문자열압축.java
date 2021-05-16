class Solution {
    public int solution(String s) {
      int min = s.length();

      for (int i = 1; i <= s.length() / 2; i++) {
        int compLeng = compression(s, i).length();
        min = Math.min(min, compLeng);
      }

      return min;
    }

    /**
     * 문자열 압축
     *
     * @param str 입력받은 문자열
     * @param i i값
     * @return 압축된 문자열
     */
    private String compression(String str, int i) {

      int count = 1;
      String compression = "";
      String pattern = "";

      for (int j = 0; j <= str.length() + i; j += i) {

        String nowStr;

        // 전 문자열과 비교할 현재 문자열
        if (j >= str.length()) { // 현재 문자열이 없을 때
          nowStr = "";
        } else if (str.length() < j + i) { // 마지막 현재 문자열일 때
          nowStr = str.substring(j);
        } else {
          nowStr = str.substring(j, j + i); // 그 외
        }

        // 1. 전 문자열이랑 똑같은지 비교한다. (맨 처음이면 비교 X)
        if (j != 0) {
          if (nowStr.equals(pattern)) { // 똑같으면
            count++;
          } else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
            compression += count + pattern;
            count = 1;
          } else { // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
            compression += pattern;
          }
        }
        // 2. i 길이만큼 문자열을 자른다.
        pattern = nowStr;
      }

      return compression;
    }

}

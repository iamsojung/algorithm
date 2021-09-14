package week11;

import java.util.HashMap;

public class programmers_뉴스클러스터링 {

    public static void main(String[] args) {

        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        solution(str1, str2);

    }

    static public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");

        int cnt1 = 0;

        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if(i+1>=arr1.length){
                break;
            }
            String temp = arr1[i] + arr1[i + 1];
            if(temp.contains(" "))
                continue;
            if (temp.matches("[a-zA-Z]+$")) {
                if (hs.containsKey(temp)) {
                    int cnt = hs.get(temp);
                    hs.put(temp, cnt + 1);
                } else {
                    hs.put(temp, 1);
                }
                System.out.println(temp);
                cnt1++;
            }

        }
        System.out.println();

        int cnt2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            if(i+1>=arr2.length){
                break;
            }
            String temp = arr2[i] + arr2[i + 1];
            if(temp.contains(" "))
                continue;
            if (temp.matches("[a-zA-Z]+$")) {
                System.out.println(temp);
                if (hs.containsKey(temp)) {
                    int cnt = hs.get(temp);
                    if(cnt>0){
                        cnt2++;
                        cnt1--;
                        hs.put(temp,cnt-1);
                    }
                }
                cnt1++;
            }

        }
      
        double ans = 0;
        double cal1 = (double)cnt1;
        double cal2 = (double)cnt2;
        if (cnt2 == 0&&cnt1==0) {
            ans = 1 * 65536;
        } else {
            ans = (cal2 / cal1) * 65536;
        }

        answer = (int) ans;
      
        return answer;
    }
}

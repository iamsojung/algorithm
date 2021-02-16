# java

```java
class Solution {
    public int[] dailyTemperatures(int[] T) {

        int[] S = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < T.length; j++) {
                cnt++;
                if (T[i]-T[j]<0) {
                    S[i] = cnt;
                    break;
                } else {
                    S[i] = 0;
                    //System.out.println(0);
                }
            }
        }

       // for(int k=0;k<S.length;k++){
        //    System.out.println(S[k]);
        //}

        return S;
    }
    
}

class Solution {
    static public int[] dailyTemperatures(int[] T) {

        int[] output = new int[T.length];

        for(int i=0;i<T.length;i++){
            int cnt = 0;
            for(int j=i;j<T.length;j++){

                if(T[i]<T[j]){
                    output[i] = cnt;
                    break;
                }
                cnt++;
            }
        }
        return output;
    }
}

/* 시간복잡도 O(N/2) , 공간복잡도 O(1)*/
class Solution {
    public void reverseString(char[] s) {
        
        for(int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
    }
}

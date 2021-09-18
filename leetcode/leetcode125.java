class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replace(" ","");
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        
        s = s.toLowerCase(); //소문자로 치환
        System.out.println(s);
        char[] temp = s.toCharArray();
        
        for(int i=0;i<temp.length;i++){
            
            if(temp[i]==temp[temp.length-i-1]){
                 System.out.println(temp[i]+"   "+temp[temp.length-1]);
                continue;
            }else{
                return false;
            }
        }
        return true;
        
    }
}

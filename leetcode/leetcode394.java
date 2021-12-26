class Solution {
    
    public String decodeString(String s) {
        //Recursive solution
        int[] i=new int[1];
        return decodeString(s,i);
    }
    
    private String decodeString(String s,int[] index)
    {
        StringBuilder result=new StringBuilder();
        
        while(index[0]<s.length() && s.charAt(index[0])!=']')
        {
            if(Character.isDigit(s.charAt(index[0]))){
                int count=0;
                while(index[0]<s.length() && Character.isDigit(s.charAt(index[0]))){
                    count=10*count+s.charAt(index[0]++)-'0';
                }
                index[0]++;
                
                String next=decodeString(s,index);
                
                while(count-->0)
                {
                    result.append(next);
                }
                index[0]++;
            }else result.append(s.charAt(index[0]++));
        }
        return result.toString();
        
    }
}

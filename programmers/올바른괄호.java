import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack();
        for(int i=0;i<arr.length;i++) {
        	
        	if(arr[i]=='(') {
        		st.add('(');
        	}else {
        		if(!st.isEmpty()){
        			st.pop();
        			
        		}else {
        			answer = false;
        			return answer;
        		}
        	}
        	
        }
        if(st.size()>0) {
        	answer = false;
        }

        return answer;
    }
}

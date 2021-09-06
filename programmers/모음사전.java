class Solution {
    static int count = 0;
    static int answer = 0;
    
    public int solution(String word) {

        dfs("",0,word);
        System.out.println(count);
        System.out.println(answer);
        return answer;
    }

    static String[] words = {"A","E","I","O","U"};

    private static void dfs(String s, int index,String word){


        if(s.length()==word.length()){
            if(s.equals(word)){
                System.out.println(s);
                System.out.println("ggggg");
                answer = count;
                return;
            }
        }
        if(s.length()>5){
            count--;
            return;
        }
        for(int i=0;i<5;i++){
            count++;
            String temp = s+words[i];
            dfs(temp,index+1,word);
        }

    }
}


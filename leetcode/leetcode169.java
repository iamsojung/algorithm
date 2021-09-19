class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                int cnt = hm.get(nums[i]);
                
                    hm.put(nums[i],cnt+1);
                    max = Math.max(cnt+1,max);
                } else{
            
                    hm.put(nums[i],1);
                max = Math.max(1,max);
               
            }

        }
        int answer = 0;
        System.out.println(nums.length/2+1);
        
        Iterator<Integer> keys = hm.keySet().iterator();
        while( keys.hasNext() ){
            int key = keys.next();
            System.out.println( key+""+ hm.get(key) );
            
            if(hm.get(key)==max){
                if(hm.get(key)>=(nums.length/2)){
                    
                    answer = key;
                    System.out.println("zzzzz"+answer);
                }
                
            }
        }        
        return answer;
    }
}v

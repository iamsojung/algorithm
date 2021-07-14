import java.util.HashMap;
import java.util.Iterator;

class Solution {

    public String solution(String[] participant, String[] completion) {
       
		String answer = "";

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < participant.length; i++) {

			if (map.containsKey(participant[i])) {

				int cnt = map.get(participant[i]);
				map.put(participant[i], cnt+1);

			} else {
				map.put(participant[i], 0);
			}
		}

		for (int j = 0; j < completion.length; j++) {

			if (map.containsKey(completion[j])) {
				int cnt = map.get(completion[j]);
				if (cnt > 0) {
					//System.out.println(completion[j]);
					map.put(completion[j], cnt-1);
				} else {
					map.remove(completion[j]);
				}
			}
		}
		Iterator<String> mapIter = map.keySet().iterator();
		 
        while(mapIter.hasNext()){
 
            String key = mapIter.next();
             answer = key;
          //  System.out.println(key);
 
        }
		return answer;
	}

}

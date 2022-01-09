class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        
        int intervals = 0;
        while (count[25] > 0) {
            for (int i = 0; i <= n; i++) {
                intervals++;
                if (i > 25) {
                    continue;
                }
                int index = 25 - i;
                if (count[index] > 0) {
                    count[index]--;
                }
                if (count[index] == 0 && count[25] == 0) {
                    break;
                }
            }
            Arrays.sort(count);
        }
        return intervals;
    }
}

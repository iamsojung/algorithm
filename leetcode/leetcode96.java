class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += numTrees(i)*numTrees(n - i - 1);
        }
        map.put(n, total);
        return total;
    }
}

class Solution {
    public int climbStairs(int n, int[]map) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(map[n] != 0) return map[n];

        map[n] = climbStairs(n-1, map)+climbStairs(n-2, map);
        return map[n];
    }
    public int climbStairs(int n) {
        int [] map = new int[n+1];
        return climbStairs(n, map);
    }
}

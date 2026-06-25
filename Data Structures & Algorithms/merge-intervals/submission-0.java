class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        int[]newInterval = intervals[0];
        ans.add(newInterval);

        for(int i = 1; i<intervals.length; i++){
            int[]interval = intervals[i];
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                newInterval = interval;
                ans.add(newInterval);
            }
        }

        return ans.toArray(new int[ans.size()][]); 
    }
}

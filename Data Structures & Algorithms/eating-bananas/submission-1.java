class Solution {
    public boolean isPossible(int bananaCount, int[] piles, int h){
        if(bananaCount == 0) return false;
        int actualHours = 0;

        for(int count: piles){
            actualHours += count / bananaCount;
            if(count % bananaCount != 0) actualHours++;
        }

        return actualHours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1; // 💡 FIX 1: Speed kam se kam 1 honi chahiye
        int max = 0;

        // 💡 FIX 2: Max speed dhoondho (sabse bada pile) bajaaye total sum ke
        for(int count: piles){
            max = Math.max(max, count);
        }

        int ans = max;

        while(min <= max){
            int mid = (min+max)/2;
            System.out.println(mid);

            if(isPossible(mid, piles, h)){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }

        return ans;
    }
}

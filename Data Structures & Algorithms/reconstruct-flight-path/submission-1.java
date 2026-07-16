class Solution {
    public void dfs(String node, HashMap<String, PriorityQueue<String>> map, List<String> ans){
        PriorityQueue<String> pq = map.get(node);

        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll(), map, ans);
        }
        ans.add(node);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket: tickets){
            if(!map.containsKey(ticket.get(0))){
                map.put(ticket.get(0), new PriorityQueue<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> ans = new ArrayList<>();
        dfs("JFK", map, ans);
        Collections.reverse(ans);

        return ans;
    }
}

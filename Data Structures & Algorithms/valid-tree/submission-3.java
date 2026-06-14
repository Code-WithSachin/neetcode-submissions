class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, -1});
        visit.add(0);
            

        while(!queue.isEmpty()){
            int [] curr = queue.poll();
            for(int nextNode: adjList.get(curr[0])){
                if(nextNode == curr[1]) continue;

                if(visit.contains(nextNode)) return false;

                queue.add(new int[]{nextNode, curr[0]});
                visit.add(nextNode);
            }
        }
        return n == visit.size();
    }
}

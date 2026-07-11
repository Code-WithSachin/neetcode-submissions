class Solution {
    class DisjointSet{
        int[]parent;
        int[]size;
        public DisjointSet(int n){
            parent = new int[n+1];
            size = new int[n+1];

            for(int i = 0; i<=n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findParent(int node){
            if(node == parent[node]) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void unionBySize(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv]+=size[pu];
            }else{
                parent[pv] = pu;
                size[pu]+=size[pv];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {

        DisjointSet ds = new DisjointSet(edges.length);
        
        for(int[]edge: edges){
            if(ds.findParent(edge[0]) == ds.findParent(edge[1])) return edge;
            else ds.unionBySize(edge[0], edge[1]);
        }

        return new int[]{};
    }
}

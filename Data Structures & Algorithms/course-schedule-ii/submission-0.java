class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0; i<numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        int inDegree[] = new int[numCourses];

        for(int [] course: prerequisites){
            adjList.get(course[1]).add(course[0]);
            inDegree[course[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0, i =0;
        int[] ans = new int[numCourses];
        while(!queue.isEmpty()){
            count++;
            int node = queue.poll();
            ans[i++] = node;
            for(int nextNode: adjList.get(node)){
                inDegree[nextNode]--;
                if(inDegree[nextNode] == 0){
                    queue.add(nextNode);
                }
            }
        }

        return count == numCourses ? ans : new int[0];
    }
}


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }        
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int dest = p[0];
            int src = p[1];
            adj.get(src).add(dest);
            indegree[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }     
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;
            
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return completedCourses == numCourses;
    }
}
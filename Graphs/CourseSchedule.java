class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int pair[] : prerequisites) {
            int course = pair[0]; //a
            int prerequisite = pair[1]; //b
            if(adj[prerequisite] == null) // 'cause by default array will have null there
                adj[prerequisite] = new ArrayList<>();
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++ ){
            if(indegree[i] == 0) //these courses have no prereq so can be started immediately
                q.offer(i);
        }

        while(!q.isEmpty()) {

            int current = q.poll();
            ans.add(current);

            if(adj[current] != null) {
                for(int next : adj[current]) {
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return ans.size() == n;
    }
}

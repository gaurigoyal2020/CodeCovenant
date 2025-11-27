class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer> ans= new ArrayList<>();
        List<Integer>[] adjacency = new List[n];
        int[] indegree = new int[n];

        for(int pair[] : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if(adjacency[prerequisite] == null)
                adjacency[prerequisite] = new ArrayList<>();
            adjacency[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            ans.add(current);

            if(adjacency[current] != null) {
                for(int next : adjacency[current]) {
                    indegree[next]--;
                    if(indegree[next] == 0)
                        q.offer(next);
                }
            }
        }
        if(ans.size() != n)
            return new int[]{};
        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}

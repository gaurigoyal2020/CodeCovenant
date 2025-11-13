class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null)
            return ans;
        
        q.offer(root);

        while(!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int n = q.size();
            
            for(int i=0; i<n; i++){
                TreeNode front = q.poll();
                row.add(front.val);
                if(i == n-1)
                    ans.add(front.val);
              
                if(front.left!=null)
                    q.offer(front.left);
                if(front.right!=null)
                    q.offer(front.right);
                
            }
        }
        return ans;
    }
}

class Solution {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }

    private int traverse(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftH = traverse(root.left);
        int rightH = traverse(root.right);

        res = Math.max(res, leftH+rightH);

        return Math.max(leftH, rightH) + 1;
    }
}

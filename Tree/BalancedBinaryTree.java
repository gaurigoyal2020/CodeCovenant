class Solution {
    public boolean isBalanced(TreeNode root) {
       return heightDiff(root) != -1;
    }

    public int heightDiff(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftH = heightDiff(root.left);
        if(leftH == -1)
            return -1;
        int rightH = heightDiff(root.right);
        if(rightH == -1)
            return -1;
        if(Math.abs(leftH - rightH) > 1) {
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
}

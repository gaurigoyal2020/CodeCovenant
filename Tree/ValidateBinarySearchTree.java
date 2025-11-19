class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidTree(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return isValidTree(root.left, min, root.val) && isValidTree(root.right, root.val, max);
    }
}

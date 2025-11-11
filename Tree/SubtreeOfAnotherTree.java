class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot ==  null)
            return true;
        if(root == null)
            return false;

        if(isSameTree(root, subRoot))
            return true;
        //traversal
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        if(root.val != subRoot.val)
            return false;
        
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}

/* ===================== */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootSB = new StringBuilder();
        StringBuilder subSB = new StringBuilder();

        serialize(root, rootSB);
        serialize(subRoot, subSB);

        String rootStr = rootSB.toString();
        String subStr = subSB.toString();

        return rootStr.contains(subStr);
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        // Wrap each value with delimiters (^ and ,)
        sb.append("^").append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}

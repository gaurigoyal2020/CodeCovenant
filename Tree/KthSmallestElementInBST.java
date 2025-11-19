class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }
        List<Integer> sortedList = new ArrayList<>();
        inOrder(root, sortedList, k);
        return sortedList.get(k-1);
    }

    public void inOrder(TreeNode node, List<Integer> list, int k) {
        if(node == null || list.size() >= k) {
            return;
        }

        inOrder(node.left, list, k);
        list.add(node.val);
        inOrder(node.right, list, k);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static final int MOD = 1_000_000_007;
        long totalSum = 0;
        long maxProduct = 0;

        //Total tree Sum
        long getTotalSum(TreeNode root) {
            if(root == null)
                return 0;
            return root.val
                + getTotalSum(root.left)
                + getTotalSum(root.right);
        }

        //Subtree sum : postorder dfs
        long dfs(TreeNode root) {
            if(root == null)
                return 0;

            //Sum of riht and left subtrees    
            long left = dfs(root.left);
            long right = dfs(root.right);

            //current subtree sum
            long subSum = root.val + left + right;

            long product = subSum * (totalSum - subSum);
            maxProduct = Math.max(maxProduct, product);
            return subSum;
        }

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        dfs(root);
        return (int)(maxProduct % MOD);

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int lMin = minDepth(root.left);
        int rMin = minDepth(root.right);

        return (root.left == null || root.right == null) ? lMin + rMin + 1 : Math.min(lMin, rMin) + 1;
    }
}
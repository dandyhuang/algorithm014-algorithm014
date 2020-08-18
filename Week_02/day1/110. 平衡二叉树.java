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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depthTree(root.left) - depthTree(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depthTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depthTree(node.left), depthTree(node.right)) + 1;
    }
}
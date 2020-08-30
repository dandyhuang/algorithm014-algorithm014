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
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        long lastVal = (long)Integer.MIN_VALUE - 1;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= lastVal) {
                return false;
            }
            lastVal = root.val;
            root = root.right;
        }
        return true;
    }

}
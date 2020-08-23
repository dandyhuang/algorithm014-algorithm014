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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList();
        if(root == null) {
            return resList;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (root == null) {
                resList.add(stack.pop().val);
            } else {
                stack.push(root);
                stack.push(null);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return resList;
    }
}
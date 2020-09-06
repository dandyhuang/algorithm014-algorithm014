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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new ArrayList<>();
        helper(root,new ArrayList<>(),resList);
        return resList;
    }

    private void helper(TreeNode root,List<Integer> list, List<String> resList) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            list.add(root.val);
            resList.add(list.stream().map(String::valueOf).collect(Collectors.joining("->")));
            list.remove(list.size() - 1);
            return;
        }
        if(root.left != null) {
            list.add(root.val);
            helper(root.left, list, resList);
            list.remove(list.size() - 1);
        }
        if(root.right != null) {
            list.add(root.val);
            helper(root.right, list, resList);
            list.remove(list.size() - 1);
        }
    }
}
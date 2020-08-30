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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preI, int preJ, int[] inorder, int inI, int inJ) {

        if (inI > inJ) {
            return null;
        }

        int val = preorder[preI];
        TreeNode root = new TreeNode(val);
        int inorderRootIdx = getInorderRootIdx(inorder, inI, inJ, val);

        root.left = buildTree(preorder, preI + 1, preI + inorderRootIdx - inI, inorder, inI, inorderRootIdx - 1);
        root.right = buildTree(preorder, preI + inorderRootIdx - inI + 1, preJ, inorder, inorderRootIdx + 1, inJ);

        return root;
    }

    private int getInorderRootIdx(int[] inorder, int inI, int inJ, int val) {

        for (int i = inI; i <= inJ; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
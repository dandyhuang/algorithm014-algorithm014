/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> resList2 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                resList2.add(node.val);
                q.addAll(node.children);
            }
            resList.add(resList2);
        }
        return resList;
    }
}
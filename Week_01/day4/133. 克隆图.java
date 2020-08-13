/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//深搜
class Solution {
    Map<Node, Node> mapNode = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }
        if (mapNode.containsKey(node)) {
            return mapNode.get(node);
        }
        Node clone = new Node(node.val);
        mapNode.put(node,clone);
        for (Node neighborNode : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighborNode));
        }
        return clone;
    }
}
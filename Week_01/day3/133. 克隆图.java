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

class Solution {

	//广搜
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> nodeMap = new HashMap<>();
        q.offer(node);
        Node clone = new Node(node.val);
        nodeMap.put(node, clone);
        while (!q.isEmpty()) {
            Node n = q.poll();
            List<Node> neighborList = n.neighbors;
            for (Node neighborNode : neighborList) {
                if (!nodeMap.containsKey(neighborNode)) {
                    q.offer(neighborNode);
                    nodeMap.put(neighborNode, new Node(neighborNode.val));
                }
                nodeMap.get(n).neighbors.add(nodeMap.get(neighborNode));
            }
        }
        return clone;
    }
}
class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer, DLinkedNode> cache;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
        cache = new HashMap<Integer, DLinkedNode>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode res) {
        res.pre.next = res.next;
        res.next.pre = res.pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode newNode) {
        newNode.pre = head;
        newNode.next = head.next;
        head.next.pre = newNode;
        head.next = newNode;
    }

}

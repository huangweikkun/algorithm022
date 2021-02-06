import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, ListNode> map;

    private int size = 0;
    private int capacity;

    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // 获取该值，并将对应的Node移动到头位置
            ListNode listNode = map.get(key);
            moveToHead(listNode);
            return listNode.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode listNode = map.get(key);
            listNode.value = value;
            moveToHead(listNode);
            return;
        }

        if (size >= capacity) {
            ListNode listNode = removeTail();
            map.remove(listNode.key);
            size--;
        }

        ListNode listNode = new ListNode(key, value);
        addToHead(listNode);

        map.put(key, listNode);
        size++;
    }

    private ListNode removeTail() {
        ListNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(ListNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addToHead(ListNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    private static class ListNode {

        // 存放key和value
        private Integer key;
        private Integer value;

        private ListNode pre;
        private ListNode next;

        public ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);

    }
}
class LRUCache {

    class Node {
        int key;
        int value;

        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);

            remove(node);
            map.remove(key);
        }

        // Cache is full
        if (map.size() == capacity) {
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        // Add new node
        Node node = new Node(key, value);

        map.put(key, node);
        insert(node);
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        Node headNext = head.next;

        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }
}
class Node{
    int key;
    int value;

    Node prev;
    Node next;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {

        // Case 1: Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            add(node);

            return;
        }

        // Case 2: Cache is full
        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        // Case 3: Insert new node
        Node node = new Node(key, value);

        add(node);
        map.put(key, node);
    }

    public void add(Node node){

        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

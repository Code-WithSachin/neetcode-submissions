class LRUCache {
    List<int[]> list;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i = 0; i<list.size(); i++){
            int[]temp = list.get(i);
            if(temp[0] == key){
                list.remove(i);
                list.add(new int[]{key, temp[1]});
                return temp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i<list.size(); i++){
            int[]temp = list.get(i);
            if(temp[0] == key){
                list.remove(i);
                list.add(new int[]{key, value});
                return;
            }
        }
        if(list.size() == capacity) list.remove(0);
        list.add(new int[]{key, value});
    }
}

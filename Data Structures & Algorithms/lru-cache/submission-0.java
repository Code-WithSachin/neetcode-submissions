class LRUCache {
    List<int[]> list;
    int capacity;
    public LRUCache(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int index = -1;
        int value = -1;
        for(int i = 0; i<list.size(); i++){
            int[]row = list.get(i);
            if(row[0] == key){
                index = i;
                value = row[1];
                break;
            }
        }
        if(index != -1){
            list.remove(index);
            list.add(new int[]{key, value});
        }
        return value;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i<list.size(); i++){
            int[]row = list.get(i);
            if(row[0] == key){
                list.remove(i);
                break;
            }
        }
        list.add(new int[]{key, value});
        if(list.size() > capacity) list.remove(0);
    }
}

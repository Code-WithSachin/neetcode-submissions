class MyCircularQueue {
    List<Integer> list;
    int capacity;
    public MyCircularQueue(int k) {
        this.capacity = k;
        list = new ArrayList<>();
    }
    
    public boolean enQueue(int value) {
        if(list.size()==capacity) return false;
        else{
            list.add(value);
            return true;
        }
    }
    
    public boolean deQueue() {
        if(list.size() == 0) return false;
        else{
            list.remove(0);
            return true;
        }
    }
    
    public int Front() {
        return list.size()==0 ? -1 :list.get(0);
    }
    
    public int Rear() {
        return list.size()==0 ? -1 : list.get(list.size()-1);
    }
    
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    public boolean isFull() {
        return list.size() == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
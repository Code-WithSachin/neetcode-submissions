class TimeMap {
    HashMap<String, HashMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> currMap;
        if(map.containsKey(key)){
            currMap = map.get(key);
            currMap.put(timestamp, value);
        }else{
            currMap = new HashMap<>();
            currMap.put(timestamp, value);
            map.put(key, currMap);
        }
    }
    
    public String get(String key, int timestamp) {

        Map<Integer, String> innerMap = map.get(key);

        if (innerMap == null) {
            return "";
        }

        // Exact match
        if (innerMap.containsKey(timestamp)) {
            return innerMap.get(timestamp);
        }

        String value = "";
        int maxTime = -1;

        for (Map.Entry<Integer, String> entry : innerMap.entrySet()) {
            if (entry.getKey() <= timestamp && entry.getKey() > maxTime) {
                maxTime = entry.getKey();
                value = entry.getValue();
            }
        }

        return value;
    }
}

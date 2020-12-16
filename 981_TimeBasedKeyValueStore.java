//Runtime 140ms, Memory 115.6 MB

class TimeMap {
    
    Map<String, TreeMap<Integer, String>> timeMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        timeMap = new HashMap<String, TreeMap<Integer, String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.containsKey(key)) {
            timeMap.get(key).put(timestamp, value);
        }
        else {
            TreeMap<Integer, String> map = new TreeMap<Integer, String>();
            map.put(timestamp, value);
            timeMap.put(key, map);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> map = timeMap.get(key);
        return map.firstKey() > timestamp ? "" : map.get(map.floorKey(timestamp));
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
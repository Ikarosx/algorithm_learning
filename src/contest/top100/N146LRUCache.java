package contest.top100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ikaros
 * @date 2020/6/1 12:03
 */
public class N146LRUCache {
    LRU<Integer, Integer> lru;
    
    class LRU<K, V> extends LinkedHashMap<K, V> {
        private final int CAPACITY;
        
        LRU(int capacity) {
            super(capacity, 0.75f, true);
            this.CAPACITY = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > CAPACITY;
        }
    }
    
    public N146LRUCache(int capacity) {
        lru = new LRU<>(capacity);
    }
    
    public int get(int key) {
        Integer integer = lru.get(key);
        return integer == null ? -1 : integer;
    }
    
    public void put(int key, int value) {
        lru.put(key, value);
    }
}

package contest.top100CN;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author Ikarosx
 * @date 2020/7/8 8:44
 */
public class N146LRU缓存机制 {
    private Map map;
    
    public N146LRU缓存机制(int capacity) {
        // TODO 手写双向链表
        map = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return (int) map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

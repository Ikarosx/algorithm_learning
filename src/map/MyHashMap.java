package map;

/**
 * @author Ikarosx
 * @date 2021/03/14
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    // 数组的默认初始化长度,为什么必须是2的次幂
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    // 阈值比例
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    // 最大容量，为什么最大容量是这个
    static final int MAXIMUM_CAPACITY = 1 << 30;
    private int defaultInitSize;
    private float defaultLoadFactor;

    // map当中entry的数量
    private int entryUseSize;

    // 数组
    private Entry<K, V>[] table = null;

    @Override
    public V put(K k, V v) {
        return null;
    }

    @Override
    public V get(K k) {
        return null;
    }
}

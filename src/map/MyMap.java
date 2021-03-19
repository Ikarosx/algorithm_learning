package map;

/**
 * @author Ikarosx
 * @date 2021/03/14
 */
public interface MyMap<K, V> {
    V put(K k, V v);

    V get(K k);

    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
}
